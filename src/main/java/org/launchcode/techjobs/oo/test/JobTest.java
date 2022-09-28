package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.assertEquals;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

@Test
public void testSettingJobId() {
    Job test_job = new Job();
    Job test_job2 = new Job();
    Assert.assertNotEquals(test_job, test_job2);
}

@Test
public void testJobConstructorSetsAllFields() {
    Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Assert.assertEquals(test_job.getName(), "Product tester");
    Assert.assertEquals(test_job.getEmployer().getValue(), "ACME");
    Assert.assertEquals(test_job.getLocation().getValue(), "Desert");
    Assert.assertEquals(test_job.getPositionType().getValue(), "Quality control");
    Assert.assertEquals(test_job.getCoreCompetency().getValue(), "Persistence");

    Assert.assertTrue(test_job instanceof Job);
    Assert.assertTrue(test_job.getEmployer() instanceof Employer);
    Assert.assertTrue(test_job.getLocation() instanceof Location);
    Assert.assertTrue(test_job.getPositionType() instanceof PositionType);
    Assert.assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
}

@Test
public void testJobsForEquality(){
    Job test_job1 = new Job("tester", new Employer("Testing"), new Location("testing location"), new PositionType("testing tester"), new CoreCompetency("Redundancy"));
    Job test_job2 = new Job("tester", new Employer("Testing"), new Location("testing location"), new PositionType("testing tester"), new CoreCompetency("Redundancy"));
    Assert.assertFalse(test_job1 == test_job2);
}

@Test
public void testToStringStartsAndEndsWithNewLine() {
    Job test_job = new Job("tester", new Employer("Testing"), new Location("testing location"), new PositionType("testing tester"), new CoreCompetency("Redundancy"));
    assertEquals(test_job.toString().charAt(0), '\n');
    assertEquals(test_job.toString().charAt(test_job.toString().length()-1), '\n');
}
@Test
public void testToStringContainsCorrectLabelsAndData() {
    Job test_job = new Job("tester", new Employer("Testing"), new Location("testing location"), new PositionType("testing tester"), new CoreCompetency("Redundancy"));
    assertEquals(test_job.toString(),
            "\nID: " + test_job.getId() + "\n" +
                    "\nName: " + test_job.getName() + "\n" +
                    "\nEmployer: " + test_job.getEmployer() + "\n" +
                    "\nLocation: " + test_job.getLocation() + "\n" +
                    "\nPosition Type: " + test_job.getPositionType() + "\n" +
                    "\nCore Competency: " + test_job.getCoreCompetency() + "\n");
}

@Test
    public void testToStringHandlesEmptyField(){
    Job test_job = new Job("", new Employer(""), new Location("testing location"), new PositionType("testing tester"), new CoreCompetency("Redundancy"));
    assertEquals(test_job.toString(),
            "\nID: " + test_job.getId() + "\n" +
                    "\nName: " + "Data not available" + "\n" +
                    "\nEmployer: " + "Data not available" + "\n" +
                    "\nLocation: " + test_job.getLocation() + "\n" +
                    "\nPosition Type: " + test_job.getPositionType() + "\n" +
                    "\nCore Competency: " + test_job.getCoreCompetency() + "\n");
}

}

