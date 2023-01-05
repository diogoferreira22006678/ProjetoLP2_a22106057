package pt.ulusofona.lp2.deisiJungle



fun router(): (CommandType) -> ((GameManager, List<String>) -> String?) {
    return { commandType ->
        when (commandType) {
            CommandType.GET -> { manager, args ->
                when (args[0]) {
                    "PLAYER_INFO" -> getPlayerInfo(manager, args.subList(1, args.size))
                    "PLAYER_BY_SPECIE" -> getPlayerBySpecie(manager, args.subList(1, args.size))
                    "MOST_TRAVELED" -> getMostTraveled(manager)
                    "TOP_ENERGETIC_OMNIVORES" -> getTopEnergeticOmnivores(manager)
                    "CONSUMED_FOODS" -> getConsumedFoods(manager)
                    else -> null
                }
            }
            CommandType.POST -> { manager, args ->
                when (args[0]) {
                    "MOVE" -> postMove(manager, args.subList(1, args.size))
                    else -> null
                }
            }
        }
    }
}

fun getPlayerInfo(manager: GameManager, args: List<String>): String?{
    val player = manager.playersJogo.firstOrNull  { it.name == args[0] }

    return if (player != null) {
        return "${player.id} | ${player.name} | ${player.totalSpecies} | ${player.currentEnergy} | ${player.currentHouse}"

    } else {
        "Inexistent player"
    }
}

fun getPlayerBySpecie(manager: GameManager, args: List<String>): String? {
    val specieId = args[0]
    val players = manager.playersJogo.filter { it.getidSpecie() == specieId }
    val names = players.map { it.name }

    return if (names.isNotEmpty()) {
        names.joinToString(",")
    } else {
        ""
    }
}

fun getMostTraveled(manager: GameManager): String {
    val sortedPlayers = manager.playersJogo.sortedByDescending { it.distanceTravelled }
    val totalHouses = manager.playersJogo.sumOf { it.distanceTravelled }

    return sortedPlayers.map { "${it.name}:${it.species}:${it.distanceTravelled}\n" }.joinToString("") + "Total:$totalHouses"
}

fun getTopEnergeticOmnivores(manager: GameManager): String? {
    val players = manager.playersJogo.filter { it.specie.typeOfFood == 3 }
    val sortedPlayers = players.sortedByDescending { it.currentEnergy }

    return if (sortedPlayers.isNotEmpty()) {
        sortedPlayers.map { "${it.name}:${it.currentEnergy}" }.joinToString("\n")
    } else {
        "Inexistent player"
    }
}

fun getConsumedFoods(manager: GameManager): String {
    val foods = manager.playersJogo.flatMap { it.foodNamesList }.distinct().sorted()
    return if (foods.isNotEmpty()) {
        foods.joinToString("\n")
    } else {
        ""
    }
}

fun postMove(manager: GameManager, args: List<String>): String?{

    val result = manager.moveCurrentPlayer(args[0].toInt(), true)

    return when {
        result.code.toString() == "INVALID_MOVEMENT" -> {
            "Movimento invalido"
        }
        result.code.toString() == "VALID_MOVEMENT" -> {
            "OK"
        }
        result.code.toString() == "CAUGHT_FOOD" -> {
            "Apanhou comida"
        }
        result.code.toString() == "NO_ENERGY" -> {
            "Sem energia"
        }
        else -> {
            "ERRO"
        }
    }
}