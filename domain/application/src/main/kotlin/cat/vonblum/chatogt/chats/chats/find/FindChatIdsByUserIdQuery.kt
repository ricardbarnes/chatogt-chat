package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import java.util.UUID

class FindChatIdsByUserIdQuery(val userId: UUID) : Query