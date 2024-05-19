package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.VisitTO;

import java.util.*;

public interface VisitService {
    VisitTO getVisitById(Long id);

    List<VisitTO> getAllVisits();
}
