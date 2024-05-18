package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;
import java.util.List;
public class MedicalTreatmentTO {
    private Long id;
    private String description;
    private TreatmentType type;
    private List<MedicalTreatmentTO> treatments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }
    public List<MedicalTreatmentTO> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentTO> treatments) {
        this.treatments = treatments;
    }
}
