package com.fdj.players.models

import com.fdj.players.models.Team
import org.junit.Assert.assertEquals
import org.junit.Test

class TeamTest {

    @Test
    fun testTeamProperties() {
        // Create a team object
        val team = Team(
            idTeam = "133702",
            idSoccerXML = "117",
            idAPIfootball = "98",
            intLoved = null,
            strTeam = "Ajaccio",
            strTeamShort = null,
            strAlternate = "AC Ajaccio, Athletic Club Aiacciu",
            intFormedYear = "1910",
            strSport = "Soccer",
            strLeague = "French Ligue 1",
            idLeague = "4334",
            strLeague2 = "Coupe de France",
            idLeague2 = "4484",
            strLeague3 = "",
            idLeague3 = null,
            strLeague4 = "",
            idLeague4 = null,
            strLeague5 = "",
            idLeague5 = null,
            strLeague6 = "",
            idLeague6 = null,
            strLeague7 = "",
            idLeague7 = null,
            strDivision = null,
            strStadium = "Stade François Coty",
            strKeywords = "L",
            strRSS = "",
            strStadiumThumb = "https://www.thesportsdb.com/images/media/team/stadium/tpspsp1420759508.jpg",
            strStadiumDescription = "Stade François Coty is a football stadium in the Corsican city of Ajaccio, France, and the home of AC Ajaccio. Its capacity is 10,660.\r\n\r\nThe stadium was inaugurated on 1 December 1969 under the name Parc des Sports de l'ACA. A crowd of 14,421 was in attendance to see AC Ajaccio defeat SC Bastia in the Corsican derby. Known informally as Timizzolu, the stadium was renovated in 2002 and renamed after François Coty, a businessman and far-right politician from Ajaccio. Since 2007, the stadium has undergone substantial improvements to enable it to host Ligue 1 matches.",
            strStadiumLocation = "Ajaccio",
            intStadiumCapacity = "10500",
            strWebsite = "ac-ajaccio.corsica",
            strFacebook = "www.facebook.com/ACAofficiel/",
            strTwitter = "twitter.com/ACAjaccio",
            strInstagram = "www.instagram.com/acajaccio",
            strDescriptionEN = "Athletic Club Ajaccio (Corsican: Athletic Club Aiacciu), commonly referred to as AC Ajaccio, ACA or simply Ajaccio, is a French association football club based in the city of Ajaccio on the island of Corsica. The club was founded in 1910 and plays in Ligue 1. The club president is Christian Leca, and the first-team is coached by manager Olivier Pantaloni, following the sacking of Christian Bracconi in October 2014. Ajaccio play their home matches at the Stade François Coty and are rivals with fellow Corsican club Bastia, with whom they contest the Corsica derby (Derby Corse).",
            strDescriptionDE = null,
            strDescriptionFR = "L'Athletic Club Ajaccio (dont le nom officiel en corse est Athletic Club Aiacciu), couramment abrégé en AC Ajaccio ou ACA, est un club de football français fondé en 1910. Il est présidé par Alain Orsoni depuis juillet 2008. L'équipe première évolue en Ligue 2 depuis la saison 2014-2015. L'AC Ajaccio a remporté deux titres de champion de France de Ligue 2 en 1967 et 2002 et un titre de champion de France amateur (National) en 1998. Il dispute ses matches à domicile au Stade François Coty.",
            strDescriptionCN = null,
            strDescriptionIT = null,
            strDescriptionJP = null,
            strDescriptionRU = null,
            strDescriptionES = "El Athletic Club Ajaccien (conocido como AC Ajaccio) es un club de fútbol francés, de la ciudad de Ajaccio en la isla de Córcega. Fue fundado en 1910 y juega en la Ligue 1 del fútbol francés. El club mantiene una tradicional rivalidad con el SC Bastia, también de la isla, con el que disputa el \"Derbi de Córcega\".",
            strDescriptionPT = null,
            strDescriptionSE = null,
            strDescriptionNL = null,
            strDescriptionHU = null,
            strDescriptionNO = null,
            strDescriptionIL = null,
            strDescriptionPL = null,
            strKitColour1 = "#ec1c24",
            strKitColour2 = "#ffffff",
            strKitColour3 = "#000000",
            strGender = "Male",
            strCountry = "France",
            strTeamBadge = "https://www.thesportsdb.com/images/media/team/badge/qpxvwy1473505505.png",
            strTeamJersey = "https://www.thesportsdb.com/images/media/team/jersey/eio9j91680810467.png",
            strTeamLogo = "https://www.thesportsdb.com/images/media/team/logo/twttqt1420759362.png",
            strTeamFanart1 = "https://www.thesportsdb.com/images/media/team/fanart/vsvwpy1420758594.jpg",
            strTeamFanart2 = "https://www.thesportsdb.com/images/media/team/fanart/txxrpq1420758610.jpg",
            strTeamFanart3 = "https://www.thesportsdb.com/images/media/team/fanart/tqvuqv1420758626.jpg",
            strTeamFanart4 = "https://www.thesportsdb.com/images/media/team/fanart/sqrsvu1420759017.jpg",
            strTeamBanner = "https://www.thesportsdb.com/images/media/team/banner/upwrpx1420758932.jpg",
            strYoutube = "www.youtube.com/user/ACAiacciuofficiel",
            strLocked = "unlocked"
        )

        // Verify the properties of the team object
        assertEquals("133702", team.idTeam)
        assertEquals("117", team.idSoccerXML)
        assertEquals("98", team.idAPIfootball)
        assertEquals(null, team.intLoved)
        assertEquals("Ajaccio", team.strTeam)
        assertEquals(null, team.strTeamShort)
        assertEquals("AC Ajaccio, Athletic Club Aiacciu", team.strAlternate)
        assertEquals("1910", team.intFormedYear)
        assertEquals("Soccer", team.strSport)
        assertEquals("French Ligue 1", team.strLeague)
        assertEquals("4334", team.idLeague)
        assertEquals("Coupe de France", team.strLeague2)
        assertEquals("4484", team.idLeague2)
        assertEquals("", team.strLeague3)
        assertEquals(null, team.idLeague3)
        assertEquals("", team.strLeague4)
        assertEquals(null, team.idLeague4)
        assertEquals("", team.strLeague5)
        assertEquals(null, team.idLeague5)
        assertEquals("", team.strLeague6)
        assertEquals(null, team.idLeague6)
        assertEquals("", team.strLeague7)
        assertEquals(null, team.idLeague7)
        assertEquals(null, team.strDivision)
        assertEquals("Stade François Coty", team.strStadium)
        assertEquals("L", team.strKeywords)
        assertEquals("", team.strRSS)
        assertEquals("https://www.thesportsdb.com/images/media/team/stadium/tpspsp1420759508.jpg", team.strStadiumThumb)
        assertEquals("Stade François Coty is a football stadium in the Corsican city of Ajaccio, France, and the home of AC Ajaccio. Its capacity is 10,660.\r\n\r\nThe stadium was inaugurated on 1 December 1969 under the name Parc des Sports de l'ACA. A crowd of 14,421 was in attendance to see AC Ajaccio defeat SC Bastia in the Corsican derby. Known informally as Timizzolu, the stadium was renovated in 2002 and renamed after François Coty, a businessman and far-right politician from Ajaccio. Since 2007, the stadium has undergone substantial improvements to enable it to host Ligue 1 matches.", team.strStadiumDescription)
        assertEquals("Ajaccio", team.strStadiumLocation)
        assertEquals("10500", team.intStadiumCapacity)
        assertEquals("ac-ajaccio.corsica", team.strWebsite)
        assertEquals("www.facebook.com/ACAofficiel/", team.strFacebook)
        assertEquals("twitter.com/ACAjaccio", team.strTwitter)
        assertEquals("www.instagram.com/acajaccio", team.strInstagram)
        assertEquals("Athletic Club Ajaccio (Corsican: Athletic Club Aiacciu), commonly referred to as AC Ajaccio, ACA or simply Ajaccio, is a French association football club based in the city of Ajaccio on the island of Corsica. The club was founded in 1910 and plays in Ligue 1. The club president is Christian Leca, and the first-team is coached by manager Olivier Pantaloni, following the sacking of Christian Bracconi in October 2014. Ajaccio play their home matches at the Stade François Coty and are rivals with fellow Corsican club Bastia, with whom they contest the Corsica derby (Derby Corse).", team.strDescriptionEN)
        assertEquals(null, team.strDescriptionDE)
        assertEquals("L'Athletic Club Ajaccio (dont le nom officiel en corse est Athletic Club Aiacciu), couramment abrégé en AC Ajaccio ou ACA, est un club de football français fondé en 1910. Il est présidé par Alain Orsoni depuis juillet 2008. L'équipe première évolue en Ligue 2 depuis la saison 2014-2015. L'AC Ajaccio a remporté deux titres de champion de France de Ligue 2 en 1967 et 2002 et un titre de champion de France amateur (National) en 1998. Il dispute ses matches à domicile au Stade François Coty.", team.strDescriptionFR)
        assertEquals(null, team.strDescriptionCN)
        assertEquals(null, team.strDescriptionIT)
        assertEquals(null, team.strDescriptionJP)
        assertEquals(null, team.strDescriptionRU)
        assertEquals("El Athletic Club Ajaccien (conocido como AC Ajaccio) es un club de fútbol francés, de la ciudad de Ajaccio en la isla de Córcega. Fue fundado en 1910 y juega en la Ligue 1 del fútbol francés. El club mantiene una tradicional rivalidad con el SC Bastia, también de la isla, con el que disputa el \"Derbi de Córcega\".", team.strDescriptionES)
        assertEquals(null, team.strDescriptionPT)
        assertEquals(null, team.strDescriptionSE)
        assertEquals(null, team.strDescriptionNL)
        assertEquals(null, team.strDescriptionHU)
        assertEquals(null, team.strDescriptionNO)
        assertEquals(null, team.strDescriptionIL)
        assertEquals(null, team.strDescriptionPL)
        assertEquals("#ec1c24", team.strKitColour1)
        assertEquals("#ffffff", team.strKitColour2)
        assertEquals("#000000", team.strKitColour3)
        assertEquals("Male", team.strGender)
        assertEquals("France", team.strCountry)
        assertEquals("https://www.thesportsdb.com/images/media/team/badge/qpxvwy1473505505.png", team.strTeamBadge)
        assertEquals("https://www.thesportsdb.com/images/media/team/jersey/eio9j91680810467.png", team.strTeamJersey)
        assertEquals("https://www.thesportsdb.com/images/media/team/logo/twttqt1420759362.png", team.strTeamLogo)
        assertEquals("https://www.thesportsdb.com/images/media/team/fanart/vsvwpy1420758594.jpg", team.strTeamFanart1)
        assertEquals("https://www.thesportsdb.com/images/media/team/fanart/txxrpq1420758610.jpg", team.strTeamFanart2)
        assertEquals("https://www.thesportsdb.com/images/media/team/fanart/tqvuqv1420758626.jpg", team.strTeamFanart3)
        assertEquals("https://www.thesportsdb.com/images/media/team/fanart/sqrsvu1420759017.jpg", team.strTeamFanart4)
        assertEquals("https://www.thesportsdb.com/images/media/team/banner/upwrpx1420758932.jpg", team.strTeamBanner)
        assertEquals("www.youtube.com/user/ACAiacciuofficiel", team.strYoutube)
        assertEquals("unlocked", team.strLocked)
    }
}