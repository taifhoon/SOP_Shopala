package com.example.productservice.query;

import lombok.Data;


public class FindProductByIdQuery {
    private String _id;

    public FindProductByIdQuery(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
