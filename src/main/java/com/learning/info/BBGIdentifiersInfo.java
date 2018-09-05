package com.learning.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BBG_IDENTIFIER_DETAILS", schema = "CORE_FEED")
public class BBGIdentifiersInfo 
{
	@Id
    @GeneratedValue
    @Column(name="IDENTIFIER_ID")
    private Long identifierId;

    @Column(name="SECURITY_TYPE")
    private String securityType;
    
    @Column(name="ID_BB_GLOBAL")
    private String idBBGlobal; //ID_BB_GLOBAL

    @Column(name="TICKER")
    private String ticker;

    @Column(name="EXCH_CODE")
    private String exchCode;

    @Column(name="NAME")
    private String name;
    
    @Column(name="MARKET_SECTOR_DES")
    private String marketSectorDescription;

    @Column(name="SECURITY_TYPE_FILE")
    private String securityTypeMRD;

    @Column(name="FEED_SOURCE")
    private String feedSource;
    
    @Column(name="ID_BB_SEC_NUM_DES")
    private String idBBSecurityNumDescription; //ID_BB_SEC_NUM_DES

   
    @Column(name="COMPOSITE_ID_BB_GLOBAL")
    private String compositeIdBBGlobal;
    
    @Column(name="ID_BB_GLOBAL_SHARE_CLASS_LEVEL")
    private String idBBGlobalShareClassLevel;   
    
    @Column(name="ID_BB_UNIQUE")
    private String idBBUnique;
        

/*    private String existingIdentifier;
    private String status = "RECEIVED";
    private String remakrs;       
    private Date createdOn;
    private String fileName;
    private String client;

	private String isin;
	
	private String cusip;
	*/


	
}
