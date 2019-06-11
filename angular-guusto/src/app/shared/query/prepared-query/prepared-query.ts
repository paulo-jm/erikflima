import { Specification } from '../specification/specification';
import { ParamBuilder } from "../../query/param/param-builder";
import { HttpParams } from '@angular/common/http';

export class PreparedQuery {

    limit: number;
    offest: number;
    specification: Specification;
    ordersBy: Map<String, String>;

    toHttpParams(): HttpParams {
        return ParamBuilder.getInstance()
            .addParam("limit", this.limit)
            .addParam("offest", this.offest)
            .addJsonParam("specification", this.specification)
            .addJsonParam("ordersBy", this.ordersBy)
            .toHttpParams();
    }

}

export class PreparedQueryBuilder {

    public static getInstance(): PreparedQueryBuilder {
        return new PreparedQueryBuilder();
    }

    private toBuild: PreparedQuery = new PreparedQuery();

    constructor() {
        this.toBuild = new PreparedQuery();
    }

    public limit(limit: number): PreparedQueryBuilder {
        this.toBuild.limit = limit;
        return this;
    }

    public offest(offest: number): PreparedQueryBuilder {
        this.toBuild.offest = offest;
        return this;
    }

    public specification(specification: Specification): PreparedQueryBuilder {
        this.toBuild.specification = specification;
        return this;
    }

    public orderby(column: string, order: string): PreparedQueryBuilder {

        if (this.toBuild.ordersBy == null) {
            this.toBuild.ordersBy = new Map();
        }
        this.toBuild.ordersBy.set(column, order);
        return this;

    }

    public build(): PreparedQuery {
        return this.toBuild;
    }


}

