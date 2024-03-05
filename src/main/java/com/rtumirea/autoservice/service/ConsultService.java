package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.dao.entity.ConsultEntity;
import com.rtumirea.autoservice.dao.repository.ConsultRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.entity.ConsultEntityMapper;
import com.rtumirea.autoservice.mapper.model.ConsultModelMapper;
import com.rtumirea.autoservice.model.ConsultModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultService {
    private final ConsultEntityMapper consultEntityMapper;
    private final ConsultModelMapper consultModelMapper;
    private final ConsultRepository consultRepository;

    @Transactional
    public ConsultModel createConsult(ConsultModel consultModel){
        log.info("Creating consult({})", consultModel);
        ConsultEntity consultEntity = consultEntityMapper.toEntity(consultModel);
        consultEntity = consultRepository.save(consultEntity);
        return consultModelMapper.toModel(consultEntity);
    }

    @Transactional
    public ConsultModel updateConsult(ConsultModel consultModel){
        log.info("Updating consult({})", consultModel);
        Optional<ConsultEntity> optConsult = consultRepository.findById(consultModel.getConsultId());
        ConsultEntity consultEntity = optConsult.orElseThrow(() -> {
            String message = String.format("Unable to find consult(%s)", consultModel);
            log.error(message);
            return new AutoServiceException(message);
        });
        consultEntity.setStatus(consultModel.getStatus());
        consultEntity = consultRepository.save(consultEntity);
        return consultModelMapper.toModel(consultEntity);
    }

    public List<ConsultModel> getAllConsultRequests(){
        log.info("Getting all consult requests");
        List<ConsultEntity> consultEntities = consultRepository.findAll();
        return consultModelMapper.toModels(consultEntities);
    }
}
