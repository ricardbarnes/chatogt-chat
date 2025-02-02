rootProject.name = "chatogt-chats"

include(
    ":domain:core",
    ":domain:application",
    ":shared:domain",
    ":shared:infrastructure",
    ":api",
    ":consumer",
    ":producer"
)