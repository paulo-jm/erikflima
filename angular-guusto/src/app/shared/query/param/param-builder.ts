import { HttpParams } from '@angular/common/http';

export class ParamBuilder {

    public static getInstance(): ParamBuilder {
        return new ParamBuilder();
    }

    private toBuilder: Map<string, string> = new Map();

    constructor() {
    }

    public addParam(param: string, value: any): ParamBuilder {
        if (value != null) {
            this.toBuilder = this.toBuilder.set(param, value.toString())
        }
        return this;
    }

    public addJsonParam(param: string, value: any): ParamBuilder {
        if (value != null) {
            this.toBuilder = this.toBuilder.set(param, JSON.stringify(value))
        }
        return this;
    }

    public toHttpParams(): HttpParams {

        let httpParams: HttpParams = null;
        if (this.toBuilder.size > 0) {
            httpParams = new HttpParams();
            this.toBuilder.forEach((value: string, key: string) => {
                httpParams = httpParams.set(key, value);
            });
        }

        return httpParams;

    }

}
