package base;

import java.util.ArrayList;

public class Cell {
   private ArrayList<Cell> near;
   private Status status;

    public Cell() {

        this.status = Status.NONE;
        near = new ArrayList<>();
    }

    void step1() {

    int around = countNearCells();
    status= status.step1(around);
    }

    void step2() {

       status =  status.step2();
    }

    void addNear(Cell cell) {

        near.add(cell);
    }

    int countNearCells(){

        int count = 0;
        for (Cell cell: near) {
            if(cell.getStatus().isExist()) {
                    count++;
            }
        }
        return count;
    }

    void turn(){

        for (Cell cell: near) {
            cell.status = cell.status.isExist() ? Status.NONE : Status.LIVE;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
