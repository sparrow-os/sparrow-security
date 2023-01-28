package com.sparrow.security.admin.repository;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import java.util.List;



public interface MicroServiceRepository {
    Long save(MicroServiceParam appParam);

    int delete(String microServiceIds);

    int disable(String microServiceIds);

    int enable(String microServiceIds);

    MicroServiceBO getMicroService(Long microServiceId);

    List<MicroServiceBO> queryMicroServices(MicroServiceQuery microServiceQuery);

    Long getMicroServiceCount(MicroServiceQuery microServiceQuery);

}