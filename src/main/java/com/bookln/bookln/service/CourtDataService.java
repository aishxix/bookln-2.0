package com.bookln.bookln.service;

import com.bookln.bookln.model.Court;
import com.bookln.bookln.model.NullCourt; // Ensure this is imported
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class CourtDataService {

        private Court[] courtArray;

        public CourtDataService() {

                courtArray = new Court[65];
                courtArray[0] = CourtFactory.getCourt("Power Hitters", "North Nazimabad",
                                "images/PowerHitters.jpg",
                                923333164366L);
                courtArray[1] = CourtFactory.getCourt("Groove Arena", "Gulistan-e-Johar", "images/Groove.PNG",
                                923153497605L);
                courtArray[2] = CourtFactory.getCourt("Fireball Arena", "A-410, Gulshan-e-Iqbal",
                                "images/FIREBALL.jpg",
                                923073833225L);
                courtArray[3] = CourtFactory.getCourt("Powerplay", "Block 10 Gulshan-e-Iqbal",
                                "images/powerplay.jpg",
                                923193497605L);
                courtArray[4] = CourtFactory.getCourt("The Sports Club", "Block 15 Gulistan-e-Johar",
                                "images/thesportsclub.jpg", 923167090600L);
                courtArray[5] = CourtFactory.getCourt("Elite Indoor", "Federal B Area Block 8 Gulberg Town",
                                "images/EliteIndoor.jpg", 923352361184L);
                courtArray[6] = CourtFactory.getCourt("Futflick",
                                "Shaheed-e-Millat Rd, Darul Aman Society P.E.C.H.S",
                                "images/FUTFLIX.PNG", 923003928092L);
                courtArray[7] = CourtFactory.getCourt("Extenders Arena", "Block 15 Gulberg Town",
                                "images/ExtendersArena.jpg", 923182294182L);
                courtArray[8] = CourtFactory.getCourt("Flex", "Block 6 PECHS", "images/Flex.jpg",
                                923241027055L);
                courtArray[9] = CourtFactory.getCourt("Aranzee Arena", "F.B Area Block 6",
                                "images/AranzeeArena.jpg",
                                923332226424L);
                courtArray[10] = CourtFactory.getCourt("Emaar Futsal", "DHA Karachi Phase VIII Zone D ,Emaar",
                                "images/KUEmaar.jpg", 923026792222L);
                courtArray[11] = CourtFactory.getCourt("SportSwing", "Block 3 PECHS", "images/sportswin.jpg",
                                923241541163L);
                courtArray[12] = CourtFactory.getCourt("Sports Spirit", "Gulshan-e-iqbal 4-A ,Plot No A-1R",
                                "images/sportspirit.jpg", 923238283392L);
                courtArray[13] = CourtFactory.getCourt("Freehit", "Block 6, PECHS --- Jamshed Road",
                                "images/freehit.jpg", 923182943399L);
                for (int i = 14; i < 65; i++) {
                        courtArray[i] = new NullCourt();
                }
        }

        // 2. Fill the remaining array slots (14 to 64) with NullCourt
        // This utilizes the Null Object Pattern so your app doesn't crash on empty
        // slots
        // for (int i = 14; i < 65; i++) {
        // courtArray[i] = new NullCourt();

        // courtArray[0] = new Court("Power Hitters", "North Nazimabad",
        // "images/PowerHitters.jpg",
        // "923333164366");
        // courtArray[1] = new Court("Groove Arena", "Gulistan-e-Johar",
        // "images/Groove.PNG", "923153423429");
        // courtArray[2] = new Court("Fireball Arena", "A-410, Gulshan-e-Iqbal",
        // "images/FIREBALL.jpg",
        // "923073833225");
        // courtArray[3] = new Court("Powerplay", "Block 10 Gulshan-e-Iqbal",
        // "images/powerplay.jpg",
        // "923193497605");
        // courtArray[4] = new Court("The Sports Club", "Block 15 Gulistan-e-Johar",
        // "images/thesportsclub.jpg",
        // "923167090600");
        // courtArray[5] = new Court("Elite Indoor", "Federal B Area Block 8 Gulberg
        // Town",
        // "images/EliteIndoor.jpg",
        // "923352361184");
        // courtArray[6] = new Court("Futflick", "Shaheed-e-Millat Rd, Darul Aman
        // Society P.E.C.H.S",
        // "images/FUTFLIX.PNG",
        // "923003928092");
        // courtArray[7] = new Court("Extenders Arena", "Block 15 Gulberg Town",
        // "images/ExtendersArena.jpg",
        // "923182294182");
        // courtArray[8] = new Court("Flex", "Block 6 PECHS", "images/Flex.jpg",
        // "923241027055");
        // courtArray[9] = new Court("Aranzee Arena", "F.B Area Block 6",
        // "images/AranzeeArena.jpg",
        // "923332226424");
        // courtArray[10] = new Court("Emaar Futsal", "DHA Karachi Phase VIII Zone D
        // ,Emaar", "images/KUEmaar.jpg",
        // "923026792222");
        // courtArray[11] = new Court("SportSwing", "Block 3 PECHS",
        // "images/sportswin.jpg", "923241541163");
        // courtArray[12] = new Court("Sports Spirit", "Gulshan-e-iqbal block 4-A ,Plot
        // No A-1R",
        // "images/sportspirit.jpg",
        // "923238283392");
        // courtArray[13] = new Court("Freehit", "Block 6, PECHS --- • Jamshed Road",
        // "images/freehit.jpg",
        // "923182943399");
        // courtArray[14] = new Court("The Spot", "A-297, Block Allama Rasheed Turabi
        // Rd", "images/spot.jpg",
        // "923333095932");
        // courtArray[15] = new Court("Legends Arena", "Stadium Lane 3,
        // Khayaban-e-Mujahid, DHA Phase 5",
        // "images/Legends arena.jpg", "923001127362");
        // courtArray[16] = new Court("Maidan at KMC Sports Complex", "Kashmir Rd,
        // Jamshed Quarters Muslimabad",
        // "images/Maidan_at_kmc.jpg", "923330624326");
        // courtArray[17] = new Court("Backyard Club", "Block 5 Clifton, Karachi",
        // "images/backyardclub.jpg",
        // "923196756090");
        // courtArray[18] = new Court("Power Play", "ST/G 29, Block 10 Gulshan-e-Iqbal",
        // "images/powerplay.jpg",
        // "923313165589");
        // courtArray[19] = new Court("Flex Pakistan", "Dr. Mahmood Husain Road,Block 6
        // P.E.C.H.S",
        // "images/flex pakistan.jpg", "923241027055");
        // courtArray[20] = new Court("The Edge", "Abul Hasan Isphahani Rd,Block 4
        // Gulshan-e-Iqbal",
        // "images/TheEdge.jpg",
        // "923390507050");
        // courtArray[21] = new Court("Sports Factory", "Main University Rd, opposite
        // Civic Centre, Essa Nagri",
        // "images/SportsFactory.jpg", "923359277770");
        // courtArray[22] = new Court("Dribbling Arena", "Block Q North Nazimabad Town",
        // "images/DribblingArena.jpg",
        // "923700028410");
        // courtArray[23] = new Court("The Legacy Court", "Gulshan-e-Kaneez Fatima",
        // "images/LegacyCourt.jpg",
        // "923126628197");
        // courtArray[24] = new Court("Xtreme Sports", "North Block B Nazimabad",
        // "images/XtremeSports.jpg",
        // "923072235656");
        // courtArray[25] = new Court("Inswing Sports", "Main Karachi University Road,
        // Block 7 Gulistan-e-Johar",
        // "images/Inswingsports.jpg", "923343062480");
        // courtArray[26] = new Court("The NCG (North Community Ground)", "Sector 11 B
        // North Karachi Twp",
        // "images/NCG.jpg", "923000900269");
        // courtArray[27] = new Court("Battlefield by Sports Club", "Block 14
        // Gulistan-e-Johar",
        // "images/Battlefield.jpg",
        // "923193008828");
        // courtArray[28] = new Court("Champions Pavilion HPGS", "Federal B Area Al Noor
        // Society Block 19 Noor",
        // "images/ChampionsPavillon.jpg", "923090214747");
        // courtArray[29] = new Court("The Ground", "Ibrahim Hyderi, District Malir",
        // "images/ground.jpeg",
        // "923423898153");
        // courtArray[30] = new Court("The Dugout", "Block B Block 16 A
        // Gulistan-e-Johar", "images/dugout.jpg",
        // "923270384688");
        // courtArray[31] = new Court("Playdium Indoor", "Block 12 Gulistan-e-Johar",
        // "images/playdiumindoor.jpg",
        // "923361240246");
        // courtArray[32] = new Court("Dreamers Arena", "Federal B Area Block 7 Gulberg
        // Town",
        // "images/dreamer arena.PNG",
        // "923327017017");
        // courtArray[33] = new Court("Elixir Arena", "Street 1, Block G North Nazimabad
        // Town",
        // "images/Elixir.jpg",
        // "923394120006");
        // courtArray[34] = new Court("Midwicket", "Quetta Town Sector 17 B Gulzar E
        // Hijri Scheme 33",
        // "images/midwickett.jpg", "923451111464");
        // courtArray[35] = new Court("Planet Arena", "Main University Rd, near PIA
        // PLANETARIUM Block 15",
        // "images/planetarena.jpg", "923120124125");
        // courtArray[36] = new Court("Urban Turf", "Siraj ud-Daulah Rd, opp. Naheed
        // super market",
        // "images/UrbanTurf.jpg",
        // "923142551179");
        // courtArray[37] = new Court("Velocity", "Street 7, Block 10 Gulberg Town",
        // "images/velocityy.jpg",
        // "923167090600");
        // courtArray[38] = new Court("The Smash", "C-183, Block I North Nazimabad
        // Town", "images/smashh.jpg",
        // "923062515026");
        // courtArray[39] = new Court("Royal Arena for Indoor Sports", "Sector F Askari
        // X",
        // "images/ROYALARENA.jpg",
        // "923004767119");
        // courtArray[40] = new Court("Lahore Indoor Arena", "Land Breez Block B Lda
        // Avenue Phase 1",
        // "images/lahoreindoor.jpg", "923134466669");
        // courtArray[41] = new Court("United Sports Arena", "B 39, Block P North
        // Nazimabad", "images/united.jpg",
        // "923037864833");
        // courtArray[42] = new Court("Big Bash Boom The Indoor Cricket Arena",
        // "58-A Multan Rd, near ShahFreed Darbar, Sabzazar Block A",
        // "images/zbigbash.jpg",
        // "923270771157");
        // courtArray[43] = new Court("Sports Kingdom", "Gulshan-e-iqbal Block 4-A near
        // Patel Hospital",
        // "images/zsportskingdom.jpg", "923235097176");
        // courtArray[44] = new Court("Astro Truf", "Gulshan-e-lqbal",
        // "images/zastroturf.jpg", "923232333212");
        // courtArray[45] = new Court("MHA Sports Arena", "Zeenat Block Allama Iqbal
        // Town, Lahore",
        // "images/zmha.jpg",
        // "923232333212");
        // courtArray[46] = new Court("Legacy Arena Iqbal Town Lahore",
        // "Bari Studios, Zeenat Block Allama Iqbal Town, Lahore",
        // "images/zlegendsarenalahore.jpg",
        // "923364422883");
        // courtArray[47] = new Court("Apex Sports Arena",
        // "Opposite Khalid Block, Safari Valley, Japan Road Bahria Town",
        // "images/zzapexsportsarena.jpg", "923338472732");
        // courtArray[48] = new Court("Boxed Arena", "F.O.E.C.H.S society near I-16",
        // "images/zzboxedarena.jpg",
        // "923105103622");
        // courtArray[49] = new Court("Sky Night", "Rawalpindi",
        // "images/zzskynight.jpg", "923426654041");
        // courtArray[50] = new Court("Stumps Rooftop", "Dubai Plaza ,6th Road
        // Chowk,Rawalpindi",
        // "images/zzstumps.jpg",
        // "923037886777");
        // courtArray[51] = new Court("CricUp - Rooftop Cricket", "Rawalpindi",
        // "images/ycricup.jpg",
        // "923312742870");
        // courtArray[52] = new Court("Game On", "C-278 Block 14 Gulistan E Jauhar
        // Karachi", "images/ygameon.jpg",
        // "923345252003");
        // courtArray[53] = new Court("Soan Garden Indoor Cricket Field", "Block D
        // Islamabad",
        // "images/ysoangarden.jpg",
        // "923065417404");
        // courtArray[54] = new Court("Sports X", "Street 698, Near Dr. AQ Khan School,
        // 513/3, Islamabad",
        // "images/ysportsx.jpg", "923361336133");
        // courtArray[55] = new Court("Junoon Indoor", "Sahiwal, Punjab",
        // "images/xjunoonindoor.jpg",
        // "923361336133");
        // courtArray[56] = new Court("Play Max", "Bharia Town, Lahore",
        // "images/xplaymax.jpg", "923361336133");
        // courtArray[57] = new Court("PIPS Sports Arena", "Adjacent PIPS Boys
        // School,Gujranwala",
        // "images/xpip.jpg",
        // "923105777666");
        // courtArray[58] = new Court("Starla Sports", "Opposite Starla Factory/ Sialkot
        // law college",
        // "images/xstarla.jpg", "923300346346");
        // courtArray[59] = new Court("Legends Field", "D-3 Sector 16 A Buffer Zone",
        // "images/LF.jpg",
        // "923008250767");
        // courtArray[60] = new Court("Final Shot", "Plot 254, Block 11, Gulshan-e-lqbal
        // Near Nipa Chorangi",
        // "images/FinalShot.jpeg", "923252141447");
        // courtArray[61] = new Court("The Padel Factory", "22 Sector 22 Korangi
        // Industrial Area",
        // "images/thePadelFactory.jpeg", "923352278287");
        // courtArray[62] = new Court("Padel Arena", "K21 Club Model Town, Lahore",
        // "images/PadelArena.jpeg",
        // "923413911999");
        // courtArray[63] = new Court("The Padel Pit", "Islamabad, Pakistan",
        // "images/padelpit.jpeg",
        // "923302271227");
        // courtArray[64] = new Court("Indoor Sports Arena-Hyderabad", "Chari Site Area,
        // Hyderabad",
        // "images/indoorHYD.jpeg", "923255881677");{}

        public Court[] getAllCourts() {
                return (courtArray);
        }

        public Court[] searchCourts(String query) {
                if (query == null || query.isEmpty()) {
                        return getAllCourts();
                }

                String lowerQuery = query.toLowerCase();
                Court[] tempResults = new Court[courtArray.length];
                int matchCount = 0;

                for (int i = 0; i < courtArray.length; i++) {
                        if (courtArray[i] != null) {
                                if (courtArray[i].getName().toLowerCase().contains(lowerQuery)) {
                                        tempResults[matchCount] = courtArray[i];
                                        matchCount++;
                                }
                        }
                }
                return Arrays.copyOf(tempResults, matchCount);
        }

        // --- NEW ALGORITHM: BUBBLE SORT ---
        public void sortCourts(Court[] courts, String order) {
                int n = courts.length;
                boolean isAscending = "asc".equals(order);

                // Outer loop: runs n times
                for (int i = 0; i < n - 1; i++) {
                        // Inner loop: compares adjacent elements
                        for (int j = 0; j < n - i - 1; j++) {

                                // Safety check: ensure we don't compare null slots
                                if (courts[j] == null || courts[j + 1] == null)
                                        continue;

                                Court c1 = courts[j];
                                Court c2 = courts[j + 1];

                                // Compare strings using Java's .compareTo()
                                // Result < 0 means c1 comes BEFORE c2
                                // Result > 0 means c1 comes AFTER c2
                                int comparison = c1.getName().compareToIgnoreCase(c2.getName());

                                boolean swapNeeded = false;

                                if (isAscending) {
                                        // For A-Z, if c1 is "Greater" (comes after) c2, i swap
                                        if (comparison > 0)
                                                swapNeeded = true;
                                } else {
                                        // For Z-A, if c1 is "Smaller" (comes before) c2, i swap
                                        if (comparison < 0)
                                                swapNeeded = true;
                                }

                                // SWAP LOGIC
                                if (swapNeeded) {
                                        Court temp = courts[j];
                                        courts[j] = courts[j + 1];
                                        courts[j + 1] = temp;
                                }
                        }
                }
        }

        public Court[] getCourtArray() {
                return courtArray;
        }

        public void setCourtArray(Court[] courtArray) {
                this.courtArray = courtArray;
        }

        // public int getI() {
        // return i;
        // }

        // public void setI(int i) {
        // this.i = i;
        // }
}