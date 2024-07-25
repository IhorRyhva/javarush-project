package com.javarush.task.task37.task3713.space.crew;

public abstract class AbstractCrewMember {
    public enum CompetencyLevel{
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
        if(value(this.competencyLevel) > value(competencyLevel)){
            this.doTheJob(request);
        }else{
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }
    private int value(CompetencyLevel competencyLevel){
        if (competencyLevel == CompetencyLevel.NOVICE)
            return 1;
        else if (competencyLevel == CompetencyLevel.INTERMEDIATE) {
            return 2;
        } else if (competencyLevel == CompetencyLevel.ADVANCED) {
            return 3;
        }else{
            return 4;
        }
    }

    protected abstract void doTheJob(String request);
}
