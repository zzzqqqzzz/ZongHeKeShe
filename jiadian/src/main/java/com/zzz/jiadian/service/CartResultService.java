package com.zzz.jiadian.service;

import com.zzz.jiadian.entity.CartResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CartResultService {
    ArrayList<CartResult> selectByUid(int uid);
}
