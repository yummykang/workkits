/*
 * This file is generated by jOOQ.
*/
package me.yummykang.entity.tables;


import javax.annotation.Generated;

import me.yummykang.entity.Workkits;
import me.yummykang.entity.tables.records.OauthCodeRecord;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthCode extends TableImpl<OauthCodeRecord> {

    private static final long serialVersionUID = 1471641451;

    /**
     * The reference instance of <code>workkits.oauth_code</code>
     */
    public static final OauthCode OAUTH_CODE = new OauthCode();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthCodeRecord> getRecordType() {
        return OauthCodeRecord.class;
    }

    /**
     * The column <code>workkits.oauth_code.code</code>.
     */
    public final TableField<OauthCodeRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>workkits.oauth_code.authentication</code>.
     */
    public final TableField<OauthCodeRecord, byte[]> AUTHENTICATION = createField("authentication", org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * Create a <code>workkits.oauth_code</code> table reference
     */
    public OauthCode() {
        this("oauth_code", null);
    }

    /**
     * Create an aliased <code>workkits.oauth_code</code> table reference
     */
    public OauthCode(String alias) {
        this(alias, OAUTH_CODE);
    }

    private OauthCode(String alias, Table<OauthCodeRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthCode(String alias, Table<OauthCodeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Workkits.WORKKITS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthCode as(String alias) {
        return new OauthCode(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthCode rename(String name) {
        return new OauthCode(name, null);
    }
}
