{
  "id": "797a781f-7046-4162-95fc-09933ef7068b",
  "name": "Address",
  "fields": [
    {
      "maxLength": 100,
      "placeHolder": "Street Name",
      "annotatedId": false,
      "id": "field_3444136150900104E11",
      "code": "TextBox",
      "name": "address_street",
      "label": "Street Name",
      "required": false,
      "readonly": false,
      "modelName": "address",
      "boundPropertyName": "street",
      "standaloneClassName": "java.lang.String",
      "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
    },
    {
      "maxLength": 3,
      "placeHolder": "#",
      "annotatedId": false,
      "id": "field_9817581443651785E11",
      "code": "TextBox",
      "name": "address_num",
      "label": "#",
      "required": false,
      "readonly": false,
      "modelName": "address",
      "boundPropertyName": "num",
      "standaloneClassName": "java.lang.Integer",
      "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
    },
    {
      "maxLength": 100,
      "placeHolder": "CP",
      "annotatedId": false,
      "id": "field_76235207241842E11",
      "code": "TextBox",
      "name": "address_cp",
      "label": "CP",
      "required": false,
      "readonly": false,
      "modelName": "address",
      "boundPropertyName": "cp",
      "standaloneClassName": "java.lang.String",
      "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
    },
    {
      "maxLength": 100,
      "placeHolder": "City",
      "annotatedId": false,
      "id": "field_2287560694369202E12",
      "code": "TextBox",
      "name": "address_city",
      "label": "City",
      "required": false,
      "readonly": false,
      "modelName": "address",
      "boundPropertyName": "city",
      "standaloneClassName": "java.lang.String",
      "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
    },
    {
      "maxLength": 100,
      "placeHolder": "Country",
      "annotatedId": false,
      "id": "field_656898561095388E11",
      "code": "TextBox",
      "name": "address_country",
      "label": "Country",
      "required": false,
      "readonly": false,
      "modelName": "address",
      "boundPropertyName": "country",
      "standaloneClassName": "java.lang.String",
      "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
    }
  ],
  "dataHolders": [
    {
      "name": "address",
      "type": "demo.client.shared.Address"
    }
  ],
  "layoutTemplate": {
    "version": 1,
    "name": "Address",
    "layoutProperties": {},
    "rows": [
      {
        "rowSpam": [
          "6",
          "6"
        ],
        "layoutColumns": [
          {
            "span": "6",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "form_id": "797a781f-7046-4162-95fc-09933ef7068b",
                  "field_id": "field_3444136150900104E11"
                }
              }
            ]
          },
          {
            "span": "6",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "form_id": "797a781f-7046-4162-95fc-09933ef7068b",
                  "field_id": "field_9817581443651785E11"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [
          "4",
          "4",
          "4"
        ],
        "layoutColumns": [
          {
            "span": "4",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "form_id": "797a781f-7046-4162-95fc-09933ef7068b",
                  "field_id": "field_76235207241842E11"
                }
              }
            ]
          },
          {
            "span": "4",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "form_id": "797a781f-7046-4162-95fc-09933ef7068b",
                  "field_id": "field_2287560694369202E12"
                }
              }
            ]
          },
          {
            "span": "4",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "form_id": "797a781f-7046-4162-95fc-09933ef7068b",
                  "field_id": "field_656898561095388E11"
                }
              }
            ]
          }
        ]
      }
    ]
  }
}
