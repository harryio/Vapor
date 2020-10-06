package io.github.sainiharry.vapor.repository.games

import com.squareup.moshi.JsonClass
import io.github.sainiharry.vapor.common.Game
import io.github.sainiharry.vapor.common.GameCategory

@JsonClass(generateAdapter = true)
internal data class GameCategoryModel(val listTitle: String, val games: List<GameModel>)

@JsonClass(generateAdapter = true)
internal data class GameModel(val title: String, val img: String)

internal fun GameCategoryModel.toGameCategory() = GameCategory(listTitle, games.toGameList())

internal fun List<GameModel>.toGameList() = map { it.toGame() }

internal fun GameModel.toGame() = Game(title, img)

internal const val GAME_JSON_DATA = "[\n" +
        "  {\n" +
        "    \"list_title\": \"Mistplay Favorites\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"RAID: ShadowLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/raid-shadow-legends/RAID_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"YAHTZEE® With Buddies DiceGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/yahtzeewithbuddies/Yahtzee_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Solitaire Grand Harvest - Free TripeaksSolitaire\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/solitaire-grand-harvest/SolitaireGrandHarvest_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Bingo Blitz™  - BingoGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/bingo-blitz/9726_GenericBanners_pack2_290x420.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Slotomania™ Free Slots: Casino Slot MachineGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/slotomania/Slotomania_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Caesars Casino: Free SlotsGames\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/caesars/CaesarsSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Bingo Pop - Live Multiplayer Bingo Games forFree\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/bingo-pop/BingoPop_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Big Farm: Mobile Harvest – Free FarmingGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/big-farm-mobile-harvest/BigFarmMobileHarvest_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Word Life - Connect crosswordspuzzle\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/word-life/WorldLife-Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Wheel of Fortune: FreePlay\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/wheel-of-fortune/WOF-portrait.jpg\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Fantasy\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"MonsterLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/monster-legends/Portrait_290x420.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Park ofMonster\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/parkofmonster/POM-Portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Wizard of Oz Free SlotsCasino\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/wizard-of-oz-slots/WoZ_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Game of Thrones Slots Casino - Free SlotMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/got-slots/GoTSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Dragon ManiaLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/dragon-mania/DragonMania_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Lords Mobile: KingdomWars\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/Lords-Mobile/LordsMobile-Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"The Wizard of Oz Magic Match 3 Puzzles &Games\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/wizzard-of-oz/WizardOfOz_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Romancing SaGaRe;univerSe\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/romancing-saga/RomancingSaga_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"RAID: ShadowLegends\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/raid-shadow-legends/RAID_Portrait.jpg\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Slots\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"Slotomania™ Free Slots: Casino Slot MachineGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/slotomania/Slotomania_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Caesars Casino: Free SlotsGames\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/caesars/CaesarsSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Huuuge Casino Slots - Slot Machines777\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/huuuge-casino-slots/HuuugeCasino_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Neverland Casino Slots 2020 - Social SlotsGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/neverland-casino/NeverlandCasino-Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Stars Slots Casino - Vegas SlotMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/huuuge-stars-slots/Stars_slots_portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"House of Fun™ : Free Slots & Casino SlotsMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/houseoffun/HoF_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Double Win Casino Slots - Real Vegas NightSlots\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/Double-Win-Casino-Slots/doublewin0310_portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Vegas Slots - DoubleDownCasino\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/doubledown-casino/VegasSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Game of Thrones Slots Casino - Free SlotMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/got-slots/GoTSlots_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Wizard of Oz Free SlotsCasino\",\n" +
        "        \"img\": \"https://assets.mistplay.com/images/timeplay/games/wizard-of-oz-slots/WoZ_Portrait.jpg\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Match 3\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"Best Fiends - Free PuzzleGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/best-fiends/unnamed.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Vineyard Valley: Match & Blast Puzzle DesignGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/vineyard-valley/VineyardValley_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"ToyBlast\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/toy-blast/mistplay-360x520-01.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Genies & Gems - Jewel & Gem MatchingAdventure\",\n" +
        "        \"img\": \"https://s3.amazonaws.com/mistplay-static/images/timeplay/games/genies-gems/GeniesGems_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"ToonBlast\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/toon-blast/mistplay-itempool-360x520.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Tile Master - Classic Triple Match & PuzzleGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/tilemaster/tilemaster_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Delicious B&B: Match 3 game & Interactivestory\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/delicious-bb/DeliciousBB_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Gummy Candy Blast - Free Match 3 PuzzleGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/gummycandyblast/gummycandy_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"MatchingtonMansion\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/matchingtonmansion/matchingtonmansion_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Puppy Blast™  - pets puzzleadventure\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/puppyblast/puppyblast_portrait.png\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Board Games\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"Bingo Blitz™  - BingoGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/bingo-blitz/9726_GenericBanners_pack2_290x420.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"BoardKings™ \",\n" +
        "        \"img\": \"https://s3.amazonaws.com/mistplay-static/images/timeplay/games/board-kings/Board+Kings_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Scrabble® GO - New WordGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/scrabble/ScrabbleGo_Portrait_June2020.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Words With Friends 2 – Free Multiplayer WordGames\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/wordswithfriends2.1/WordsWithFriends_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Tile Master - Classic Triple Match & PuzzleGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/tilemaster/tilemaster_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Dice With Buddies™ Free - The Fun Social DiceGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/dice-with-buddies/Dice_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Ultimate Cribbage - Classic Board CardGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/ultimate_cribbage/Portrait_Image.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"CROSS-STITCH: COLORINGBOOK\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/cross-stitch/360X520.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"YAHTZEE® With Buddies DiceGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/yahtzeewithbuddies/Yahtzee_Portrait.jpg\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"list_title\": \"Other Games\",\n" +
        "    \"games\": [\n" +
        "      {\n" +
        "        \"title\": \"Big Farm: Mobile Harvest – Free FarmingGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/big-farm-mobile-harvest/BigFarmMobileHarvest_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"State of Survival: Survive the ZombieApocalypse\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/stateofsurvival/SOS0531_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Guns of Glory: Build an Epic Army for theKingdom\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/guns-of-glory/GOG0531_portrait.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Genies & Gems - Jewel & Gem MatchingAdventure\",\n" +
        "        \"img\": \"https://s3.amazonaws.com/mistplay-static/images/timeplay/games/genies-gems/GeniesGems_Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Who Wants to Be a Millionaire? Trivia & QuizGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/millionaire/mil_static_mistplay-360x520.png\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Party in my Dorm: College Life Roleplay ChatGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/party-in-my-dorm/Pimd+-+Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Stars Slots Casino - Vegas SlotMachines\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/huuuge-stars-slots/Stars_slots_portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"June's Journey - HiddenObjects\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/junes-journey-hidden-object/JunesJourney-Portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Double Win Casino Slots - Real Vegas NightSlots\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/Double-Win-Casino-Slots/doublewin0310_portrait.jpg\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"title\": \"Nonogram - Jigsaw PuzzleGame\",\n" +
        "        \"img\": \"https://mistplay-static.s3.amazonaws.com/images/timeplay/games/nonogram/nonogram_portrait.png\"\n" +
        "      }\n" +
        "    ]\n" +
        "  }\n" +
        "]"