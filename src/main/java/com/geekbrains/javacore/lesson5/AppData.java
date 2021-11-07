package com.geekbrains.javacore.lesson5;

import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }


    /**
     * biba kuka boba
     * <p>
     * <p>
     * (0)  (1)   (2)              (0)  (1)    (2)
     * 1     2    3                ""    ""    ""
     * 4     5    6
     * 7     8    9
     */
    public String[] getRow(int index) {
        if (index == 0) {
            return this.header;
        }

        int novyIndex = index - 1;
        int length = data[novyIndex].length;

        String[] result = new String[length];

        int i = 0;
        int[] strokaData = data[novyIndex];

        while (i < length) {
            result[i] = String.valueOf(strokaData[i]);
            i++;
        }
        return result;
    }

    public void saveResult(List<String[]> all) {
        this.header = all.get(0);

        for (int i = 1; i < all.size() - 1; i++) {
            for (int j = 0; j < all.get(i).length; j++) {
                data[i - 1][j] = Integer.parseInt(all.get(i)[j]);
            }
        }
    }
}
