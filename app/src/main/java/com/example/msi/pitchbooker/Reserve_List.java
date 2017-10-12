package com.example.msi.pitchbooker;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

/**
 * Created by MSI on 10/11/2017.
 */

public class Reserve_List {
    private boolean status;
    private String message;
    private ArrayList < Reserve_list > reserve_lists;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Reserve_list> getReserve_lists() {
        return reserve_lists;
    }

    public void setReserve_lists(ArrayList<Reserve_list> reserve_lists) {
        this.reserve_lists = reserve_lists;
    }

    class Reserve_list {
        private long reserve_id;
        private long field_id;
        private long customer_id;

        public long getField_id() {
            return field_id;
        }

        public void setField_id(long field_id) {
            this.field_id = field_id;
        }

        public long getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(long customer_id) {
            this.customer_id = customer_id;
        }

        private String reserve_date;
        private String reserve_start_time;
        private String reserve_end_time;

        public long getReserve_id() {
            return reserve_id;
        }

        public void setReserve_id(long reserve_id) {
            this.reserve_id = reserve_id;
        }

        public String getReserve_date() {
            return reserve_date;
        }

        public void setReserve_date(String reserve_date) {
            this.reserve_date = reserve_date;
        }

        public String getReserve_start_time() {
            return reserve_start_time;
        }

        public void setReserve_start_time(String reserve_start_time) {
            this.reserve_start_time = reserve_start_time;
        }

        public String getReserve_end_time() {
            return reserve_end_time;
        }

        public void setReserve_end_time(String reserve_end_time) {
            this.reserve_end_time = reserve_end_time;
        }
    }
}
