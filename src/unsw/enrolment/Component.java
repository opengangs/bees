package unsw.enrolment;

interface Component {

    public int getMark();
    //public int setMark (int mark);
    public void add (Component child);       // appends a child mark object.
    public void remove (Component child);    // removes a child mark object.
}