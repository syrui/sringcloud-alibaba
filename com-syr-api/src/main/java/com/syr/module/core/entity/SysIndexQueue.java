package com.syr.module.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_index_queue")
public class SysIndexQueue implements Serializable {
    public static final String SYS_INDEX_QUEUE_ID = "sysIndexQueueId";
    public static final String SYS_INDEX_OBJECT_TYPE_CODE = "sysIndexObjectTypeCode";
    public static final String SYS_OBJECT_ID = "sysObjectId";
    @TableId
    private java.lang.Long sysIndexQueueId;
    /** SYS_INDEX_OBJECT_TYPE_CODE - 索引名称 */

    private java.lang.String sysIndexObjectTypeCode;
    /** SYS_OBJECT_ID - 对象id */
    private java.lang.Long sysObjectId;


}