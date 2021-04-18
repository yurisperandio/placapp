package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameScoreViewModelTest {

     private val gameScoreContractMock: GameScoreContract = mock {}
     private val insertRegisterMock: InsertRegister = mock {}

    private lateinit var sut: GameScoreViewModel

    @Before
    fun setup() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)
    }

    @Test
    fun `Should update athlete names correctly`() {
        val athleteOne = "athlete_one"
        val athleteTwo = "athlete_two"

        sut.onCreate(athleteOne, athleteTwo)

        assertEquals(sut.athleteOne, athleteOne)
        assertEquals(sut.athleteTwo, athleteTwo)
    }

    @Test
    fun `Should increase Athlete One score when onAthleteOneIncrease is called`() {
        sut.onAthleteOneIncreaseRoundOne()
        assertEquals(sut.formattedAthleteOneScoreRoundOne, "01")

        sut.onAthleteOneIncreaseRoundTwo()
        assertEquals(sut.formattedAthleteOneScoreRoundTwo, "01")

        sut.onAthleteOneIncreaseRoundThree()
        assertEquals(sut.formattedAthleteOneScoreRoundThree, "01")

        sut.onAthleteTwoIncreaseRoundOne()
        assertEquals(sut.formattedAthleteTwoScoreRoundOne, "01")

        sut.onAthleteTwoIncreaseRoundTwo()
        assertEquals(sut.formattedAthleteTwoScoreRoundTwo, "01")

        sut.onAthleteTwoIncreaseRoundThree()
        assertEquals(sut.formattedAthleteTwoScoreRoundThree, "01")
    }

//    @Test
//    fun `Should call onInsertRegisterFails when insertRegister fails`() {
//        val insertRegisterFailsMock: InsertRegister = mock {
//            given { it.execute(any()) }.willReturn { true }
//        }
//
//        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterFailsMock)
//
//        sut.onExitPressed()
//
//        verify(gameScoreContractMock, times(1)).onInsertRegisterFails()
//    }





}