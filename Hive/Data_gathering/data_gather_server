from flask import Flask, request
import json

app = Flask(__name__)
i = 0

@app.route('/post',methods=['POST'])
def post():
    jsonEncode = request.form.get('a')
    jsonDecode = json.loads(jsonEncode)
    # print jsonDecode
    print (jsonDecode['data']['mac'])
    i = i + 1
    return 'welcome'



if __name__ == '__main__':
    app.run(debug=True)

