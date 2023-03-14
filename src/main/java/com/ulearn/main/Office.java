package com.ulearn.main;

public class Office {
    
    private String block; 
    private String level;
    private String room;
    
    public Office(String block, String level, String room) {
        this.block = block;
        this.level = level;
        this.room = room;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String printOffice() {
        return "Office [block=" + block + ", level=" + level + ", room=" + room + "]";
    }


}
