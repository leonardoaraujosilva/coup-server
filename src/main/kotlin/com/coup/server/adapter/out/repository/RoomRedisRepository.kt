package com.coup.server.adapter.out.repository

import com.coup.server.domain.model.Room
import com.coup.server.port.out.repository.RoomRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class RoomRedisRepository(
    private val redis: RedisTemplate<String, String>,
    private val json: ObjectMapper
) : RoomRepository {

    companion object {
        const val ROOM_KEY = "Room:%s"
        const val ACTIVE_ROOMS_SET_KEY = "ActiveRooms"
    }

    override fun save(room: Room): Room {
        room.id = room.id ?: UUID.randomUUID()
        val key = getKey(room.id!!)
        val payload = json.writeValueAsString(room)

        // TODO playerList could be a set

        redis.opsForValue().set(key, payload)
        redis.opsForSet().add(ACTIVE_ROOMS_SET_KEY, room.id.toString())
        return room
    }

    override fun findById(id: UUID): Optional<Room> {
        val key = getKey(id)
        val payload = redis.opsForValue().get(key) ?: return Optional.empty()
        val room = json.readValue(payload, Room::class.java)
        return Optional.of(room)
    }

    override fun findAll(): List<Room> {
        val values = redis.opsForSet().members(ACTIVE_ROOMS_SET_KEY)
        val list = ArrayList<Room>()

        values!!.forEach { roomIdAsString ->
            val id = UUID.fromString(roomIdAsString)
            findById(id).ifPresent{ room -> list.add(room) }
        }

        return list
    }

    override fun deleteById(id: UUID) {
        val key = getKey(id)
        redis.opsForSet().remove(ACTIVE_ROOMS_SET_KEY, id.toString())
        redis.opsForValue().getAndDelete(key)
    }

    private fun getKey(id: UUID) : String {
        return String.format(ROOM_KEY, id)
    }
}