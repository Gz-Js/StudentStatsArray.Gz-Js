public class StudentStatsArray
{
    // Add private final variable to hold Students array
    private final Student[] students;
    public StudentStatsArray(Student[] students)
    {
        // Constructor code
        this.students = students;
    }
    // Returns the average gpa of the students
    public double averageGpa()
    {
        double avgGpa = 0.0;
        for (int i = 0; i < this.students.length; i++)
        {
            double temp = students[i].getGpa();
            avgGpa = temp + avgGpa;
        }
        return (avgGpa/this.students.length);
    }
    // Returns the gpa range of the students
    public double getGpaRange()
    {
        double maxGpa = this.students[0].getGpa();
        double minGpa = this.students[0].getGpa();
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getGpa() > maxGpa)
            {
                maxGpa = this.students[i].getGpa();
            }
        }
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getGpa() < minGpa)
            {
                minGpa = this.students[i].getGpa();
            }
        }
        return maxGpa - minGpa;
    }

    // Returns the name of the student that has the longest length
    public String getLongestName()
    {
        String longestName = this.students[0].getName();
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getName().length() > longestName.length())
            {
                longestName = this.students[i].getName();
            }
        }
        return longestName;
    }

    // Returns a count of the number freshman students
    public int getNumFreshman()
    {
        int counter = 0;
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getYear() == 1)
            {
                counter++;
            }
        }
        return counter;
    }

    // Returns the index of the first student with a name equal to name.
    // Returns -1 if not found
    public int search(String name)
    {
        int index = 0;
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getName().toLowerCase().equals(name.toLowerCase()))
            {
                index = i;
                break;
            }
        }
        return index;
    }

    // Returns the index of the first student with a gpa greater than or equal to the gpa
    // Returns -1 if not found
    public int search(double gpa)
    {
        int index = 0;
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getGpa() == gpa)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    // Returns 1 if the students are sorted in ascending order by their gpa; -1 if they
    // are sorted in descending order; 0 otherwise.
    public int sortStatus()
    {
        int yes = 0;
        double lastSmGpa = this.students[0].getGpa();
        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i].getGpa() > lastSmGpa)
            {
                lastSmGpa = this.students[i].getGpa();
                yes = 1;
            }
            else if (this.students[i].getGpa() < lastSmGpa)
            {
                yes = 0;
                break;
            }
        }
        if (yes == 0)
        {
            for (int i = this.students.length-1; i > 0; i--)
            {
                if (this.students[i].getGpa() > lastSmGpa)
                {
                    lastSmGpa = this.students[i].getGpa();
                    yes = 0;
                    break;
                }
                else if (this.students[i].getGpa() < lastSmGpa)
                {
                    yes = -1;
                }
            }
        }
        return yes;
    }


    // Returns the array of students in JSON like format
    public String toString()
    {
        String newString = "";
        for (int i = 0; i < this.students.length; i++)
        {
            if (i == 0)
            {
                newString += "[\n{\n\tname: <student[" + i + "] " + this.students[i].getName() + ">,\n\tgpa: <student[" + i + "] " + this.students[i].getGpa() + ">,\n\tyear: <student[" + i + "] " + this.students[i].getYear() + ">\n},\n,,,";
            }
            else if (i == this.students.length - 1)
            {
                newString += "\n{\n\tname: <student[length - " + i + "] "+ this.students[i].getName() + ">,\n\tgpa: <student[length - " + i + "] " + this.students[i].getGpa() + ">,\n\tyear: <student[length - " + i + "] " + this.students[i].getYear() + ">\n},\n]";
            }
            else
            {
                newString += "\n{\n\tname: <student[length - " + i + "] "+ this.students[i].getName() + ">,\n\tgpa: <student[length - " + i + "] " + this.students[i].getGpa() + ">,\n\tyear: <student[length - " + i + "] " + this.students[i].getYear() + ">\n},\n,,,";
            }

        }
        return newString;
    }
}