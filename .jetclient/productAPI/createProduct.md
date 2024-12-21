```toml
name = 'createProduct'
method = 'POST'
url = 'http://localhost:8181/api/v1/products'
sortWeight = 2000000
id = 'ecd05e3c-a67b-40c5-b238-695c1506bd11'

[body]
type = 'JSON'
raw = '''
{
  "productName": "iPhone 16Pro MAX",
  "productPrice": 45000.75,
  "productQuantity": 1,
  "productImage" : "iPhone.jpg"
}'''
```
