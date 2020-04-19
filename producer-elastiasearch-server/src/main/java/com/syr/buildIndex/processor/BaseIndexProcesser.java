package com.syr.buildIndex.processor;



import com.syr.module.base.result.BusinessException;
import com.syr.module.base.search.IIndexProvider;
import com.syr.module.base.search.ISearchEntity;
import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 索引进程基类
 */
public abstract class BaseIndexProcesser implements IProcesser{

    private Logger logger = Logger.getLogger(this.getClass().getName());
	private boolean isMaster;
	@Autowired
	IndexQueueServiceFactory indexQueueServiceFactory;
	@Value("${app.init.Host.isMaster:false}")
	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

    @Scheduled(cron="${app.search.solr.server.indexUpdateFrequency:0/2 * * * * ?}")
    public void process(){
		if (!this.isMaster) {
			return;
		}

    	synchronized(this){
	        try {
				indexQueueServiceFactory.buildIndexTimer(getElasticsearchRepository(),getProvider(),getObjectTypeCode());

	        } catch (BusinessException e) {

	        } catch(Throwable tr){ //NOSONAR
	            logger.error(tr.getMessage(),tr);
	        }
    	}
    }

    public abstract ElasticsearchRepository getElasticsearchRepository();



    public abstract IIndexProvider<? extends ISearchEntity> getProvider();

    public abstract SysIndexObjectTypeCodeEnum getObjectTypeCode();

}
