package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.repository.MicroServiceRepository;
import com.sparrow.security.admin.protocol.enums.SecurityAdminError;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MicroServiceService {
    @Inject
    private MicroServiceRepository microServiceRepository;

    private void validateSaveMicroService(MicroServiceParam microServiceParam) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(microServiceParam.getName()), SecurityAdminError.MICRO_SERVICE_NAME_IS_EMPTY);
    }

    public Long saveMicroService(MicroServiceParam microServiceParam) throws BusinessException {
        this.validateSaveMicroService(microServiceParam);
        return this.microServiceRepository.save(microServiceParam);
    }

    public Integer deleteMicroService(String microServiceIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(microServiceIds), SecurityAdminError.MICRO_SERVICE_ID_IS_EMPTY);
        return this.microServiceRepository.delete(microServiceIds);
    }

    public Integer enableMicroService(String microServiceIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(microServiceIds), SecurityAdminError.MICRO_SERVICE_ID_IS_EMPTY);
        return this.microServiceRepository.enable(microServiceIds);
    }

    public Integer disableMicroService(String microServiceIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(microServiceIds), SecurityAdminError.MICRO_SERVICE_ID_IS_EMPTY);
        return this.microServiceRepository.disable(microServiceIds);
    }

    public ListRecordTotalBO<MicroServiceBO> queryAllMicroService() {
        return queryMicroService(null);
    }

    public ListRecordTotalBO<MicroServiceBO> queryMicroService(MicroServiceQuery microServiceQuery) {
        Long totalRecord = this.microServiceRepository.getMicroServiceCount(microServiceQuery);
        List<MicroServiceBO> microServiceBoList = null;
        if (totalRecord > 0) {
            microServiceBoList = this.microServiceRepository.queryMicroServices(microServiceQuery);
        }
        return new ListRecordTotalBO<>(microServiceBoList, totalRecord);
    }

    public MicroServiceBO getMicroService(Long microServiceId) throws BusinessException {
        Asserts.isTrue(microServiceId == null, SecurityAdminError.MICRO_SERVICE_ID_IS_EMPTY);
        return this.microServiceRepository.getMicroService(microServiceId);
    }
}