package easy;

public class StudentAttendanceRecordI0551 {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'A'){
                absentCount++;
                if (absentCount >= 2){
                    return false;
                }
            }
            if (s.charAt(i) == 'L'){
                lateCount++;
                if (lateCount >= 3){
                    return false;
                }
            }
            else {
                lateCount = 0;
            }
        }
        return true;
    }
}
