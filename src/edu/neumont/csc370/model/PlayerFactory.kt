package edu.neumont.csc370.model

import java.util.*

/**
 * Created by stephen on 10/22/15.
 */
object PlayerFactory {

    fun getPlayersForPhase(difficulty : String, startingAmount : Double) : List<List<Player>> = when(difficulty) {
        "phase 1" -> genPhaseOnePlayers(startingAmount)
        "phase 2" -> genPhaseTwoPlayers(startingAmount)
//        "phase 3" -> genPhaseThreePlayers(startingAmount)
        else -> listOf<List<Player>>()
    }

    fun getPhaseTwoPlayers(startingPurse : Double) : List<Player> {
        return listOf(MiserPlayer(startingPurse), MiddleMan(startingPurse), BigSpender(startingPurse))
    }

    private fun genPhaseOnePlayers(startingAmount : Double) : List<List<Player>> {
        // FIXME: this should be a list of sets, to get every combination
        val basicPlayerSet = basicPlayerSet(startingAmount)

        val permutation_One = listOf(BigSpender(startingAmount), MiddleMan(startingAmount), MiddleMan(startingAmount))
        val permutationOne = listOf(MiserPlayer(startingAmount), MiddleMan(startingAmount), MiddleMan(startingAmount))
        val permutationTwo = listOf(MiserPlayer(startingAmount), MiserPlayer(startingAmount), MiddleMan(startingAmount))
        val permutation_Two = listOf(MiserPlayer(startingAmount), MiserPlayer(startingAmount), BigSpender(startingAmount))
        val permutationThree = listOf(MiserPlayer(startingAmount), BigSpender(startingAmount), BigSpender(startingAmount))
        val permutation_Three = listOf(MiddleMan(startingAmount), BigSpender(startingAmount), BigSpender(startingAmount))


        return listOf(basicPlayerSet, permutation_One, permutationOne,
                permutation_Two, permutationTwo, permutationThree, permutation_Three)
    }

    private fun basicPlayerSet(initAmount : Double) : List<Player> {
        val lowbie = MiserPlayer(initAmount)
        val middie = MiddleMan(initAmount)
        val biggie = BigSpender(initAmount)

        return listOf(lowbie, middie, biggie)
    }

    private fun genPhaseTwoPlayers(startingAmount : Double) : List<List<Player>>{
        var playerTypes = listOf<String>();
        playerTypes += "cheapskate"
        playerTypes += "cheapskate"
        playerTypes += "adaptiveplayer"

        var players = listOf<Player>()
        for(playerString in playerTypes) {
            players += this.getPlayer(playerString, startingAmount)
        }

        return listOf(players)
    }

    private fun getPlayer(playerType: String,
                          startingPurse : Double,
                          startingBidRatio : Double = .25) : Player = when(playerType.toLowerCase()) {
        "miserplayer" -> MiserPlayer(startingPurse)
        "middleman" -> MiddleMan(startingPurse)
        "bigspender" -> BigSpender(startingPurse)
        "cheapskate" -> Cheapskate(startingPurse)
        else -> AdaptivePlayer(startingPurse, startingBidRatio)
    }
}