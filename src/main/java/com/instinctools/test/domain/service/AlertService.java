package com.instinctools.test.domain.service;


import com.instinctools.test.app.repository.entity.AlertEntity;

import java.util.List;

public interface AlertService {
    List<AlertEntity> getAlerts();

    AlertEntity getAlertByID(Long alertId);

    List<AlertEntity> getAlertsByTagName(String tagName);

    List<AlertEntity> getAlertsByUserName(String userName);

    void save(AlertEntity alertEntity);

    AlertEntity getAlertByName(Long id);
}
