package com.instinctools.test.serviceImpl;


import com.instinctools.test.app.repository.dao.AlertDao;
import com.instinctools.test.app.repository.entity.AlertEntity;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.domain.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertDao alertRepository;

    @Override
    public List<AlertEntity> getAlerts() {
        List<AlertEntity> alertEntities = alertRepository.findAll();
        return alertEntities;
    }

    @Override
    public AlertEntity getAlertByID(Long alertId) {
        AlertEntity alertEntity = alertRepository.findById(alertId);
        return alertEntity;
    }

    @Override
    public List<AlertEntity> getAlertsByTagName(String tagName) {
        List<AlertEntity> alertEntities = alertRepository.findByTagName(tagName);
        return alertEntities;
    }

    @Override
    public List<AlertEntity> getAlertsByUserName(String userName) {
        List<AlertEntity> alertEntities = alertRepository.findByUserName(userName);
        return alertEntities;
    }

    @Override
    public void save(AlertEntity alertEntity) {
        alertRepository.save(alertEntity);
    }

    @Override
    public AlertEntity getAlertByName(Long id) {
        return null;
    }
}
