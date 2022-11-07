package org.launchcode.techjobs.oo.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job test_job_1 = new Job();
        Job test_job_2 = new Job();

        assertNotEquals(test_job_1.getId(), test_job_2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
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
    public void testJobsForEquality(){
        Job test_job_4 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        Job test_job_5 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));

        assertFalse(test_job_4.equals(test_job_5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job_6 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        String stringToTest = test_job_6.toString();
        String test = "\n";

        assertEquals('\n', stringToTest.charAt(0));
        assertEquals('\n', stringToTest.charAt(stringToTest.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test_job_7 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        String stringToTest2 = test_job_7.toString();

        assertEquals("Name: Typing monkey", stringToTest2);

    }

}