DELETE /bbs

PUT /bbs
{

    "mappings": {
        "properties": {

            "id": {
                "type": "long",
                "index": true
            },
            "title": {
                "type": "text",
                "analyzer": "my_custom_analyzer"
            },
            "content": {
                "type": "text",
                "analyzer": "my_custom_analyzer"
            },
            "created": {
                "type": "date",
                "index": false
            }

        }
    },

    "settings": {
        "analysis": {

            "analyzer": {
                
                "my_custom_analyzer": {
                    "type": "custom",
                    "char_filter": [],
                    // "tokenizer": "standard_tokenizer",
                    "tokenizer": "nori_tokenizer",
                    "filter": ["lowercase_filter"]
                }

            },
            "char_filter": {

            },
            "tokenizer": {

                "standard_tokenizer": {
                    "type": "standard"
                }

            },
            "filter": {

                "lowercase_filter": {
                    "type": "lowercase"
                }

            }

        }
    }

}


GET /bbs/_search
{}
GET /bbs/_search
{
    "query": {
      "match": {
        "content": "doc 3 content"
      }
    }
}


POST /bbs/_doc/1
{
    "id": "1111",
    "title": "문서1",
    "content": "문서1 내용",
    "created": "2025-03-07T00:00:00Z"
}


POST /bbs/_doc/2
{
    "id": "2222",
    "title": "doc 2",
    "content": "doc 2 content",
    "created": "2025-03-07T00:00:00Z"
}

POST /bbs/_doc/3
{
    "id": "3333",
    "title": "doc 3",
    "content": "doc 3 content",
    "created": "2025-03-07T00:00:00Z"
}

POST /bbs/_doc/4
{
    "id": "4444",
    "title": "doc 4",
    "content": "Doc 4 content4",
    "created": "2025-03-07T00:00:00Z"
}
































