export class Endopoint {

    endopoint: string;

    resources: Map<string, string>;

    getUrl(resource: string, ...args: any[]) {

        if (this.resources && this.resources.has(resource)) {
            let path = this.resources.get(resource);
            if (args && args.length > 0) {
                for (let index = 0; index < args.length; index++) {
                    path = path.replace(`{${index}}`, args[index]);
                }
            }
            return `${this.endopoint}/${path}`;
        }

        return null;

    }

}

export class EndopointBuilder {

    public static getInstance(): EndopointBuilder {
        return new EndopointBuilder();
    }

    constructor() {
        this.toBuilder = new Endopoint();
    }

    private toBuilder: Endopoint;

    public endopoint(endopoint: string): EndopointBuilder {
        this.toBuilder.endopoint = endopoint;
        return this;
    }

    public addResource(resourceName: string, resourcePath: string): EndopointBuilder {
        
        if(this.toBuilder.resources == null) {
            this.toBuilder.resources = new Map();
        }
        this.toBuilder.resources.set(resourceName, resourcePath);
        return this;
    }

    public build(): Endopoint {
        return this.toBuilder;
    }

}

