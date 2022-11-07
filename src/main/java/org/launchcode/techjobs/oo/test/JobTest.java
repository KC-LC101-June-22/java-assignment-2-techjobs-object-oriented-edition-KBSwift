package org.launchcode.techjobs.oo.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();

        assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() != null);
        assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() != null);
        assertEquals(testJob.getEmployer().getValue(), "ACME");

        assertTrue(testJob.getLocation() != null);
        assertEquals(testJob.getLocation().getValue(), "Desert");

        assertTrue(testJob.getPositionType() != null);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");

        assertTrue(testJob.getCoreCompetency() != null);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job firstJobTest = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        Job secondJobTest = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));

        assertFalse(firstJobTest.equals(secondJobTest));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringToTest = testJob.toString();
//        String testing = "\n";

        assertEquals('\n', stringToTest.charAt(0));
        assertEquals('\n', stringToTest.charAt(stringToTest.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        String testingString = testJob.toString();

        assertEquals("Name: Typing monkey", testingString);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency(""));

        String testString = testJob.toString();
        String correctEmptyFieldMessage = "Data not available";

        String correctLocationString = String.format("\nLocation: %s\n", correctEmptyFieldMessage);
        String correctCoreCompetencyString = String.format("\nCore Competency: %s\n", correctEmptyFieldMessage);

        assertTrue(testString.contains(correctLocationString));
        assertTrue(testString.contains(correctCoreCompetencyString));

        String correctOutput = "\nID: " + testJob.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";

        assertEquals(correctOutput, testString);
    }

}