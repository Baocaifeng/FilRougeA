package tests.unitaires;

import fr.uv1.bettingServices.*;
import fr.uv1.bettingServices.exceptions.AuthenticationException;
import fr.uv1.bettingServices.exceptions.BadParametersException;
import fr.uv1.bettingServices.exceptions.ExistingCompetitorException;
import fr.uv1.utils.MyCalendar;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

public class CompetitorTest {
    private Competitor pc1, pc2, pc3, madrid, barca;
    private Betting betting;
    private Competition liga, uefa;


    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code exécuté après l'exécution de tous les tests
    }

    @Before
    public void setUp() throws Exception {
        this.setBetting(this.plugToBetting());
        // Code exécuté avant chaque test
    }

    @After
    public void tearDown() throws Exception {
        pc1 = null;
        pc2 = null;
        pc3 = null;
        madrid= null;
        betting = null;
        liga = null;
        uefa = null;
        // Code exécuté après chaque test
    }

    @Test
    public void hasValidName() {
        pc1 = new Individual(new String("Durante"), new String("Miguel"),
                new String("20-07-1980"));

        pc2 = new Individual(new String("!&dsdjsqp"), new String("Miguel"),
                new String("20-07-1980"));
        pc3 = new Individual(new String("Durante"), new String("Miguel%£"),
                new String("20-07-1980"));
        assertTrue((pc1.hasValidName()==true)&&(pc2.hasValidName()==false)&&(pc3.hasValidName()==false));


    }

    @Test
    public void addMemberOK() {
        testTeamWithCompetitorsOK();
        Collection<Competitor> listCompetitors = new HashSet<Competitor>();
        listCompetitors.add(pc1);
        listCompetitors.add(pc2);
        assertTrue(listCompetitors.equals(madrid.getMembers()));
    }

    @Test
    public void addMemberNull() {
        testTeamWithNullCompetitors();
        assertTrue(barca.getMembers().isEmpty());
    }

    @Test
    public void addMemberExist() {
        testTeamWithCompetitorsExist();
        Collection<Competitor> listCompetitors = new HashSet<Competitor>();
        listCompetitors.add(pc1);
        assertTrue(listCompetitors.equals(madrid.getMembers()));
    }

    @Test
    public void deleteMember() throws ExistingCompetitorException, BadParametersException {
        testTeamWithCompetitorsOK();
        madrid.deleteMember(pc1);
        Collection<Competitor> listCompetitors = new HashSet<Competitor>();
        listCompetitors.add(pc2);
        assertTrue(listCompetitors.equals(madrid.getMembers()));

    }


    @Test
    public void addCompetitionOK() {
        testTeamWithCompetitionsOK();
        assertTrue((madrid.getCompetitions().size() == 2)&&(barca.getCompetitions().size() == 2));

    }

    @Test
    public void addCompetitionNull() {
        testTeamWithNullCompetitions();
        assertTrue(madrid.getCompetitions().isEmpty());

    }

    @Test
    public void removeCompetition() throws BadParametersException {
        testTeamWithCompetitionsOK();
        madrid.removeCompetition(madrid.getCompetitions().iterator().next());
        assertTrue(madrid.getCompetitions().size() == 1);
    }


    @Test
    public void equalsTeam(){
        madrid = new Team(new String("Madrid"));
        barca = new Team(new String("Barca"));
        assertTrue((madrid.equals("Madrid")==true)&&(barca.equals("Madrid")==false));

    }

    @Test
    public void equalsIndividual(){
        pc1 = new Individual(new String("Durante"), new String("Miguel"),
                new String("20-07-1980"));
        pc2 = new Individual(new String("Ramos"), new String("Sergio"),
                new String("20-07-1980"));

        assertTrue((pc1.equals("Durante","Miguel")==true)&&(pc2.equals("Durante","Miguel")==false));
    }

    public void setUpTeamWithCompetitorsOK() {
        try {
            pc1 = this.getBetting().createCompetitor(new String("Durant"),
                    new String("Miguel"), new String("20-07-1984"),
                    this.getManagerPassword());
            pc2 = this.getBetting().createCompetitor(
                    new String("Duranto"), new String("Miguel"),
                    new String("13-12-1983"), this.getManagerPassword());

            madrid = this.getBetting().createCompetitor(
                    new String("Madrid"), this.getManagerPassword());
            madrid.addMember(pc1);
            madrid.addMember(pc2);

        } catch (Exception e) {
            assert (false);
        }
    }
    private void setUpTeamWithCompetitorsExist() {
        try {
            pc1 = this.getBetting().createCompetitor(new String("Durant"),
                    new String("Miguel"), new String("20-07-1984"),
                    this.getManagerPassword());
            madrid = this.getBetting().createCompetitor(
                    new String("Madrid"), this.getManagerPassword());
            madrid.addMember(pc1);
            madrid.addMember(pc1);

        } catch (Exception e) {
        }
    }

    private void setUpTeamWithNullCompetitors() {
        try {
            barca = this.getBetting().createCompetitor(
                    new String("Barca"), this.getManagerPassword());
            barca.addMember(null);
        } catch (Exception e) {

        }

    }




    public void testTeamWithCompetitorsOK() {
        try {
            this.setUpTeamWithCompetitorsOK();
        } catch (Exception e) {
        }

    }

    public void testTeamWithNullCompetitors() {
        try {
            this.setUpTeamWithNullCompetitors();
        } catch (Exception e) {
        }

    }
    public void testTeamWithCompetitorsExist() {
        try {
            this.setUpTeamWithCompetitorsExist();
        } catch (Exception e) {
        }

    }

    private void setUpTeamWithCompetitionsOK() {
        try {
            madrid = this.getBetting().createCompetitor(
                    new String("Madrid"), this.getManagerPassword());
            barca = this.getBetting().createCompetitor(
                    new String("Barca"), this.getManagerPassword());
            Collection<Competitor> listCompetitors = new HashSet<Competitor>();
            listCompetitors.add(madrid);
            listCompetitors.add(barca);
            this.getBetting().addCompetition("UEFA Champions League",new MyCalendar(2018, 8, 20),listCompetitors,this.getManagerPassword());
            this.getBetting().addCompetition("Liga",new MyCalendar(2018, 8, 20),listCompetitors,this.getManagerPassword());

        } catch (Exception e) {
            assert (false);
        }
    }

    private void setUpTeamWithNullCompetitions() {
        try {
            madrid = this.getBetting().createCompetitor(
                    new String("Madrid"), this.getManagerPassword());
            madrid.addCompetition(liga);
            madrid.addCompetition(uefa);
        } catch (Exception e) {
        }
    }



    public void testTeamWithCompetitionsOK() {
        try {
            this.setUpTeamWithCompetitionsOK();
        } catch (Exception e) {
        }

    }


    public void testTeamWithNullCompetitions() {
        try {
            this.setUpTeamWithNullCompetitions();
        } catch (Exception e) {
        }

    }


    public Betting plugToBetting() {
        return new BettingSite();
    }

    public String getManagerPassword() {
        return "password";
    }
    protected Betting getBetting() {
        return betting;
    }

    protected void setBetting(Betting betting) throws NullPointerException {
        if (betting == null)
            throw new NullPointerException("The bettingSoft cannot be null");
        this.betting = betting;
    }

}