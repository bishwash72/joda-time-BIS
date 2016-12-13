package org.joda.time.chrono;

/**
 * Nepali date conversion utilities and database.
 */
public class BISDateUtils {
    private static final int FIRST_BIS_YEAR_SUPPORTED = 2000;

    /**
     * Date Database useful for converting from/to Nepali/English dates.
     *
     * Basically, this is an array of arrays. Each sub-array represents a year. Each year contains
     * number of days in each month as array of integers.
     *
     * Start BIS Date : 2000 / 1 / 1
     * Start AD Date : 1943 / 4 / 14
     */
    public final static int[][] data = new int[][]{
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
            new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
            new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
            new int[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30},
            new int[]{30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
            new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
    };

    static int getTotalDaysInYear(int y) {
        int pos = y - FIRST_BIS_YEAR_SUPPORTED;
        int days = 0;

        for (int j = 0; j < 12; ++j) {
            days = days + data[pos][j];
        }

        return days;
    }

    // 0 for first month
    static int getTotalDaysInYearTillMonth(int y, int m) {
        int pos = y - FIRST_BIS_YEAR_SUPPORTED;
        int days = 0;

        for (int j = 0; j < 12; ++j) {
            if (j == m) break;
            days = days + data[pos][j];
        }

        return days;
    }

    static int getTotalDaysInYearsMonth(int y, int m) {
        int pos = y - FIRST_BIS_YEAR_SUPPORTED;

        return data[pos][m-1];
    }

    static int getMonthByYearDays(int y, int d){
        int pos = y - FIRST_BIS_YEAR_SUPPORTED;
        int days = 0;

        for (int j = 0; j < 12; ++j) {
            days = days + data[pos][j];
            if (d < days){
                return j + 1;
            }
        }
        return 1;
    }

    public static int getDayOfMonth(int y, int doy){
        int pos = y - FIRST_BIS_YEAR_SUPPORTED;
        int dayOfMonth = 1;

        for (int j = 0; j < 12; ++j) {
            if (doy <= data[pos][j]){
                dayOfMonth = doy;
                break;
            }
            doy = doy - data[pos][j];
        }
        return dayOfMonth;
    }
}