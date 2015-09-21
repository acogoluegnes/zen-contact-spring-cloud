package com.zenika;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acogoluegnes on 02/09/15.
 */
public class ContactsResponse {

    String origin;

    boolean ok;

    List<Contact> results = new ArrayList<Contact>();

    public ContactsResponse(String origin, boolean ok, List<Contact> results) {
        this.origin = origin;
        this.ok = ok;
        this.results = results;
    }

    public ContactsResponse() {}

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Contact> getResults() {
        return results;
    }

    public void setResults(List<Contact> results) {
        this.results = results;
    }
}
