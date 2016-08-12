{
  "id": "0a082a23-b66d-46c3-b3a2-421b1a851680",
  "name": "Department",
  "fields": [
    [
      {
        "maxLength": 100,
        "placeHolder": "Dep. Name",
        "annotatedId": false,
        "code": "TextBox",
        "id": "field_3023936262032718E11",
        "name": "department_name",
        "label": "Dep. Name",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "department",
        "boundPropertyName": "name",
        "standaloneClassName": "java.lang.String",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextBoxFieldDefinition"
      }
    ],
    [
      {
        "nestedForm": "797a781f-7046-4162-95fc-09933ef7068b",
        "annotatedId": false,
        "code": "SubForm",
        "id": "field_0078348673342664E11",
        "name": "department_address",
        "label": "Address",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "department",
        "boundPropertyName": "address",
        "standaloneClassName": "demo.client.shared.Address",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.relations.SubFormFieldDefinition"
      }
    ],
    [
      {
        "creationForm": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701",
        "editionForm": "6d17cb14-4ea9-4bd3-afdc-7e7d814ea701",
        "columnMetas": [
          {
            "label": "Name",
            "property": "name"
          },
          {
            "label": "Last Name",
            "property": "lastName"
          },
          {
            "label": "Birthday",
            "property": "birthday"
          },
          {
            "label": "Married",
            "property": "married"
          },
          {
            "label": "Address",
            "property": "address"
          },
          {
            "label": "Other Adresses",
            "property": "adresses"
          }
        ],
        "annotatedId": false,
        "code": "MultipleSubForm",
        "id": "field_759479997347897E11",
        "name": "department_employees",
        "label": "Employees",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "department",
        "boundPropertyName": "employees",
        "standaloneClassName": "demo.client.shared.User",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.relations.MultipleSubFormFieldDefinition"
      }
    ],
    [
      {
        "placeHolder": "Dep. Description",
        "rows": 4,
        "annotatedId": false,
        "code": "TextArea",
        "id": "field_667267893244311E11",
        "name": "department_description",
        "label": "Dep. Description",
        "required": false,
        "readonly": false,
        "validateOnChange": true,
        "modelName": "department",
        "boundPropertyName": "description",
        "standaloneClassName": "java.lang.String",
        "serializedFieldClassName": "org.kie.workbench.common.forms.model.impl.basic.textBox.TextAreaFieldDefinition"
      }
    ]
  ],
  "dataHolders": [
    {
      "name": "department",
      "type": "demo.client.shared.Department"
    }
  ],
  "layoutTemplate": {
    "version": 1,
    "name": "Department",
    "layoutProperties": {},
    "rows": [
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_3023936262032718E11",
                  "form_id": "0a082a23-b66d-46c3-b3a2-421b1a851680"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_667267893244311E11",
                  "form_id": "0a082a23-b66d-46c3-b3a2-421b1a851680"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_0078348673342664E11",
                  "form_id": "0a082a23-b66d-46c3-b3a2-421b1a851680"
                }
              }
            ]
          }
        ]
      },
      {
        "rowSpam": [],
        "layoutColumns": [
          {
            "span": "12",
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.livespark.formmodeler.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_759479997347897E11",
                  "form_id": "0a082a23-b66d-46c3-b3a2-421b1a851680"
                }
              }
            ]
          }
        ]
      }
    ]
  }
}
