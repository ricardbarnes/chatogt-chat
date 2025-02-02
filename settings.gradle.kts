rootProject.name = "chatogt-chat"

include(
    ":domain:core",
    ":domain:application",
    ":shared:domain",
    ":shared:infrastructure",
    ":api",
    ":consumer",
    ":producer"
)