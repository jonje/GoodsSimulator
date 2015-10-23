package edu.neumont.csc370.model

/**
 * Created by stephen on 10/22/15.
 */
object PlayerFactory {

    fun getPlayersForPhase(difficulty : String) : List<Player> = when(difficulty) {
        "phase 1" -> genPhaseOnePlayers()
        "phase 2" -> genPhaseTwoPlayers()
        "phase 3" -> genPhaseThreePlayers()
        else -> listOf<Player>()
    }

    private fun genPhaseOnePlayers() : List<Player> {
        // FIXME: this should be a list of sets, to get every combination

        val multiplier = 1.0 // scratch: should the multiplier be injected?

        val lowbie = MiserPlayer(10.00, multiplier)
        val middie = MiddleMan(10.00, multiplier)
        val biggie = BigSpender(10.00, multiplier)

        return listOf(lowbie, middie, biggie)
    }

    private fun genPhaseTwoPlayers() : List<Player> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun genPhaseThreePlayers() : List<Player> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}