import { Specification } from './specification';

export class SearchSpecification implements Specification {

    q: string;

}

export class SearchSpecificationBuilder {

    public static getInstance(): SearchSpecificationBuilder {
        return new SearchSpecificationBuilder();
    }

    private toBuild: SearchSpecification = new SearchSpecification();;

    public q(q: string): SearchSpecificationBuilder {
        this.toBuild.q = q;
        return this;
    }

    public build(): SearchSpecification {
        return this.toBuild;
    }

}
