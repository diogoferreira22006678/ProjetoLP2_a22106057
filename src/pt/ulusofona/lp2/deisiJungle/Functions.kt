package pt.ulusofona.lp2.deisiJungle

fun router(): (CommandType) -> (GameManager, List<String>) -> String {
    return { commandType ->
        when (commandType) {
            CommandType.GET -> {
                {return gameManager, args ->
                    when (args[0]) {
                        "PLAYER_INFO" -> {
                            return "",
                        }
                        "PLAYERS_BY_SPECIE" -> {
                           return ""
                        }
                        "MOST_TRAVELED" -> {
                            return ""
                        }
                        "TOP_ENERGETIC_OMNIVORES" -> {
                            return ""
                        }
                        "CONSUMED_FOODS" -> {
                            return ""
                        }
                        else -> {
                            return "Invalid command"
                        }
                    }
                }
            }
            CommandType.POST -> {
                { gameManager, args ->
                    when (args[0]) {
                        "CREATE_PLAYER" -> {
                            return ""
                        }
                        "MOVE" -> {
                            return ""
                        }
                        "EAT" -> {
                            return ""
                        }
                        "SLEEP" -> {
                            return ""
                        }
                        else -> {
                            return "Invalid command"
                        }
                    }
                }
            }
        }
    }
}
