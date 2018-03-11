package com.company;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;


public class Person implements Serializable {
    public String Firstname;
    public String Lastname;
    public short Age;
    public long Birthday;


    @Override
    public String toString() {
        return Firstname + " " + Lastname + " " + Age + " " + Birthday;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.Firstname);
        out.writeUTF(this.Lastname);
        out.writeShort(this.Age);
        out.writeLong(this.Birthday);
    }

    public void readExternal(ObjectInput in) throws IOException {
        this.Firstname  = in.readUTF();
        this.Lastname = in.readUTF();
        this.Age = in.readShort();
        this.Birthday = in.readLong();
    }
}
