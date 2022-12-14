package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){

        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String toString(){
        String employerString;
        String locationString;
        String positionString;
        String competencyString;

        if(name == ""){
            name = "Data not available";
        }

        if(employer == null || employer.toString() == ""){
            employerString = "Data not available";
        }
        else{
            employerString = employer.toString();
        }

        if(location == null || location.toString() == ""){
            locationString = "Data not available";
        }
        else{
            locationString = location.toString();
        }

        if(positionType == null || positionType.toString() == ""){
            positionString = "Data not available";
        }
        else{
            positionString = positionType.toString();
        }

        if(coreCompetency == null || coreCompetency.toString() == ""){
            competencyString = "Data not available";
        }
        else{
            competencyString = coreCompetency.toString();
        }

        return "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employerString + "\n" +
                "Location: " + locationString + "\n" +
                "Position Type: " + positionString + "\n" +
                "Core Competency: " + competencyString + "\n";
    }
}