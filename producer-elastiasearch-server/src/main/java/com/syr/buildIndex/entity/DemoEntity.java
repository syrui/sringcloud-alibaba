package com.syr.buildIndex.entity;



import com.syr.module.base.search.ISearchEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName= "demo_entity", type= "demo", shards = 3, replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity extends ISearchEntity {

    /** PRODUCT_ID - 商品id */
    @Id
    private  Long productId;
    /** PRICE - 价格 */
    @Field(type = FieldType.Double)
    private Double price;
    /** SKU_NAME - sku名称 */
    @Field(type = FieldType.Keyword)
    private String skuName;
    /** SKU_DESC - 商品规格描述 */
    @Field(type = FieldType.Keyword)
    private String skuDesc;
    /** WEIGHT - 重量 */
    @Field(type = FieldType.Double)
    private Double weight;
    /** TM_ID - 品牌(冗余) */

    /** CATALOG3_ID - 三级分类id（冗余) */
    @Field(type = FieldType.Keyword)
    private Long catalog3Id;
    /** SKU_DEFAULT_IMG - 默认显示图片(冗余) */
    @Field(type = FieldType.Text)
    private String skuDefaultImg;

    @Field(type = FieldType.Object)
    private int[] bounds;

}
