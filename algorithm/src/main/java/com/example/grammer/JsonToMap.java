package com.example.grammer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * /**
 *
 * @ClassName: JsonToMap
 * @description:
 * @author: pengyi
 * @create: 2021-05-21 22:23
 **/
public class JsonToMap {

    public static void main(String[]args) {
        String jsonMap = "{\"contract_sg.imerchantsettle_query\":[\"tnt_inst_id\",\"contract_version\",\"rmc_pk\",\"contract_id\",\"trans_event\",\"trans_context\"" +
                ",\"iasc_sg.iasc_settle_order\":[\"gmt_create\",\"\",\"tnt_inst_id\",\"settle_order_id\",\"gmt_modified\",\"settle_apply_id\"" +
                ",\"iasc_sg.iasc_settle_order_ext\":[\"gmt_create\",\"\",\"tnt_inst_id\",\"ext_id\",\"settle_order_id\",\"gmt_modified\",\"ext_type\"" +
                ",\"ipdc.pdc_pt_cgt_ct\":[\"gmt_create\",\"pt_vrsn\",\"gmt_modified\",\"cgt_code\",\"pt_code\",\"ct_code\"" +
                ",\"ipdc.ipdc_prod_sale_product\":[\"gmt_create\",\"tnt_inst_id\",\"pd_vrsn\",\"sale_vrsn\",\"sale_code\",\"inst_id\",\"id\",\"gmt_modified\",\"pd_code\"" +
                ",\"iasc_sg.iasc_settle_apply\":[\"gmt_create\",\"\",\"tnt_inst_id\",\"gmt_modified\",\"request_id\",\"settle_apply_id\"" +
                ",\"ipdc.pdc_p\":[\"tnt_inst_id\",\"gmt_create\",\"pd_vrsn\",\"inst_id\",\"id\",\"gmt_modified\",\"pt_vrsn\",\"pt_code\",\"pd_code\"" +
                ",\"iar_sg.ipay_ar_ii_m\":[\"tnt_inst_id\",\"gmt_create\",\"ar_vrsn\",\"ar_no\",\"pd_sale_code\",\"ar_inst_code\",\"env\",\"gmt_modified\",\"pd_sale_vrsn\"" +
                "}";
        Map<String, Set<String>> mp = new HashMap<>();
        ObjectMapper mpper = new ObjectMapper();

        String jsonMap1 = "{\"contract_sg.imerchantsettle_query\":[\"tnt_inst_id\",\"contract_id\",\"contract_id_version\",\"contract_version\",\"consumer_system\",\"rmc_pk\",\"get_json_object_odps(trans_context,'$.REQUEST_ID')\",\"rmc_time\",\"trans_context\",\"content\",\"rmc_machine_ip\",\"rmc_sub_host\",\"path\",\"hostname\",\"zone\",\"trans_event\",\"rmc_host\"" +
                ",\"ipdc.pdc_pt_cgt_ct\":[\"crtor\",\"gmt_create\",\"mrg_cts\",\"rmc_dbType\",\"rmc_database\",\"is_mrg\",\"ct_nm\",\"rmc_pk\",\"rmc_time\",\"pt_vrsn\",\"gmt_modified\",\"cgt_code\",\"is_sgl\",\"rmc_datasource\",\"rmc_sub_host\",\"last_moder\",\"ct_alias_nm\",\"rmc_host\",\"rmc_table\",\"rmc_version\",\"ct_modified\",\"pt_code\",\"agr_lvl\",\"ct_code\"" +
                ",\"ipdc.ipdc_prod_sale_product\":[\"gmt_create\",\"tnt_inst_id\",\"st_code\",\"sale_pd_rel\",\"rmc_time\",\"gmt_modified\",\"rmc_datasource\",\"rmc_sub_host\",\"pd_vrsn\",\"sale_code\",\"allow_min_contracts\",\"rmc_host\",\"rmc_table\",\"inst_id\",\"allow_max_contracts\",\"id\",\"gmt_end\",\"val_obj\",\"pd_code\",\"crtor\",\"rmc_dbType\",\"rmc_database\",\"rmc_pk\",\"last_moder\",\"sale_vrsn\",\"gmt_strt\",\"rmc_version\"" +
                ",\"ipdc.pdc_p\":[\"tnt_inst_id\",\"gmt_create\",\"st_code\",\"gmt_tst_strt\",\"sp_vrsn\",\"chl_cg_alias_nm\",\"sale_end\",\"ptype\",\"rmc_time\",\"source\",\"gmt_modified\",\"is_ab_test\",\"rmc_datasource\",\"rmc_sub_host\",\"pd_vrsn\",\"is_ready\",\"data_vrsn\",\"chl_cg_codes\",\"console_type\",\"rmc_host\",\"rmc_table\",\"inst_id\",\"id\",\"gmt_end\",\"pd_data\",\"pt_code\",\"val_obj\",\"pd_code\",\"pd_id\",\"sale_strt\",\"is_std\",\"crtor\",\"rmc_dbType\",\"rmc_database\",\"rmc_pk\",\"pt_vrsn\",\"ext_info\",\"pd_env\",\"last_moder\",\"pd_nm\",\"gmt_real_strt\",\"gmt_strt\",\"rmc_version\",\"sp_code\",\"biz_st_code\"" +
                ",\"iar_sg.ipay_ar_ii_m\":[\"gmt_create\",\"ar_nm\",\"ar_no\",\"gmt_invld_due\",\"gmt_modified_utc\",\"memo\",\"rmc_time\",\"gmt_sign\",\"moder_tp\",\"gmt_vld_utc\",\"gmt_vld_due_utc\",\"pd_sale_code\",\"app_id\",\"pd_cd_val\",\"pd_code\",\"rmc_database\",\"ar_cd\",\"rmc_pk\",\"ext_info\",\"ar_cnl_code\",\"rmc_version\",\"ar_inst_code\",\"ar_tpl_pd_code\",\"tnt_inst_id\",\"ar_cntl_inf\",\"gmt_vld_due\",\"gmt_inval_utc\",\"gmt_modified\",\"gmt_vld\",\"rmc_datasource\",\"pd_sale_vrsn\",\"ar_cd_val\",\"rmc_sub_host\",\"gmt_invld_due_utc\",\"pd_vrsn\",\"ar_vrsn\",\"pd_cd\",\"rmc_host\",\"ar_st_code\",\"rmc_table\",\"ip_role_id\",\"rmc_dbType\",\"gmt_sign_utc\",\"env\",\"last_moder\",\"ar_tp_code\",\"ar_tpl_pd_vrsn\",\"gmt_create_utc\",\"gmt_inval\"" +
                "}";
        Map<String, Set<String>> mp1 = new HashMap<>();

        try {
            mp = mpper.readValue(jsonMap, new TypeReference<HashMap<String, Set<String>>>() {});
            mp1 = mpper.readValue(jsonMap1, new TypeReference<HashMap<String, Set<String>>>() {});
            System.out.println(mpper.writeValueAsString(mp));
            System.out.println(mpper.writeValueAsString(mp1));
            Map<String, Set<String>> finalMp = mp1;
            boolean nonContains = mp.entrySet().stream().anyMatch(e ->{
                String key = e.getKey();
                Set<String> columns = e.getValue();
                columns.remove("");
                if(Objects.nonNull(finalMp.get(key)) &&
                        !finalMp.get(key).containsAll(columns)
                    ){
                    return true;
                }
                return false;
            });
            Map<String, Set<String>> inconsitanc = mp.entrySet().stream().filter(e ->{
                String key = e.getKey();
                Set<String> columns = e.getValue();
                columns.remove("");
                if(Objects.nonNull(finalMp.get(key)) &&
                        !finalMp.get(key).containsAll(columns)
                ){
                    return true;
                }
                return false;
            }).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

            System.out.printf(String.valueOf(nonContains));
            System.out.println(mpper.writeValueAsString(inconsitanc));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
